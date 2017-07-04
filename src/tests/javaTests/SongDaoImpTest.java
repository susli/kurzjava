import com.mycompany.audiolibrary.Song;
import com.mycompany.audiolibrary.SongDao;
import com.mycompany.audiolibrary.SongDaoImp;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by stepanmudra on 04.07.17.
 */
public class SongDaoImpTest{

    @Test
    public void findAll() throws Exception {
        SongDao songDao = new SongDaoImp();
        List<Song> songs = songDao.findAll();
        Song song = new Song();

        assertTrue(song.equals(songs.get(0)));

        song = new Song("IDK", "Corko", "Húko", 12, 1999, "speed metal", "12:12");
        assertTrue(song.equals(songs.get(1)));

        song = new Song("Netuším", "Lopata", "Ostrava", 12, 2015, "slow metal", "16:33");
        assertTrue(song.equals(songs.get(2)));

        song = new Song("IDK", "Nikoto", "Assembly", 12, 2014, "pop", "3:13");
        assertTrue(song.equals(songs.get(3)));

        song = new Song("Možná", "Heyja", "Húko", 6, 1999, "speed metal", "4:50");
        assertTrue(song.equals(songs.get(4)));

        song = new Song("Jako", "Despacito", "Lusi", 3, 2017, "pop", "4:51");
        assertTrue(song.equals(songs.get(5)));

        song = new Song("Jako", "Kura", "Makeš", 2, 2012, "rock", "5:40");
        assertTrue(song.equals(songs.get(6)));

        song = new Song("IDK", "Mezinkoš", "Makeš", 3, 2017, "rock", "4:13");
        assertTrue(song.equals(songs.get(7)));

        song = new Song();
        assertTrue(!song.equals(songs.get(7)));
    }

    @Test
    public void findByAlbum() throws Exception {
        SongDao songDao = new SongDaoImp();
        List<Song> songs = songDao.findByAlbum("Húko");
        Song song = new Song("IDK", "Corko", "Húko", 12, 1999, "speed metal", "12:12");
        Song song1 = new Song("Možná", "Heyja", "Húko", 6, 1999, "speed metal", "4:50");

        assertTrue(song.equals(songs.get(0)));
        assertTrue(song1.equals(songs.get(1)));
    }

    @Test
    public void findByInterpret() throws Exception {
        SongDao songDao = new SongDaoImp();
        Song song = new Song("Možná", "Heyja", "Húko", 6, 1999, "speed metal", "4:50");
        Song song1 = new Song("Jako", "Kura", "Makeš", 2, 2012, "rock", "5:40");
        List<Song> songs = songDao.findByInterpret("Heyja");

        assertTrue(song.equals(songs.get(0)));
        assertTrue(!song1.equals(songs.get(0)));
    }

    @Test
    public void findByGenre() throws Exception {
        SongDao songDao = new SongDaoImp();
        List<Song> songs = songDao.findByGenre("pop");
        Song song = new Song("IDK", "Nikoto", "Assembly", 12, 2014, "pop", "3:13");
        Song song1 = new Song("Jako", "Despacito", "Lusi", 3, 2017, "pop", "4:51");

        assertTrue(song.equals(songs.get(0)));
        assertTrue(song1.equals(songs.get(1)));
    }

    @Test
    public void findByYear() throws Exception {
        SongDao songDao = new SongDaoImp();
        List<Song> songs = songDao.findByYear(2014);
        Song song = new Song("IDK", "Nikoto", "Assembly", 12, 2014, "pop", "3:13");

        assertTrue(song.equals(songs.get(0)));
    }

    @Test
    public void findbyName() throws Exception {
        SongDao songDao = new SongDaoImp();
        List<Song> songs = songDao.findByName("Možná");
        Song song = new Song("Možná", "Heyja", "Húko", 6, 1999, "speed metal", "4:50");

        assertTrue(song.equals(songs.get(0)));
    }

    @Test
    public void getInterprets() throws Exception {
        SongDao songDao = new SongDaoImp();
        List<String> interprets = songDao.getInterprets();

        assertEquals("interpret", interprets.get(0));
        assertEquals("Corko", interprets.get(1));
        assertEquals("Lopata", interprets.get(2));
        assertEquals("Nikoto", interprets.get(3));
        assertEquals("Heyja", interprets.get(4));
        assertEquals("Despacito", interprets.get(5));
        assertEquals("Kura", interprets.get(6));
        assertEquals("Mezinkoš", interprets.get(7));
    }

    @Test
    public void getYears() throws Exception {
        SongDao songDao = new SongDaoImp();
        List<Integer> years = songDao.getYears();

        assertTrue(1970 == years.get(0));
        assertTrue(1999 == years.get(1));
        assertTrue(2015 == years.get(2));
        assertTrue(2014 == years.get(3));
        assertTrue(1999 == years.get(1));
        assertTrue(2017 == years.get(4));
        assertTrue(2012 == years.get(5));
        assertTrue(2017 == years.get(4));
    }

    @Test
    public void getAlbums() throws Exception {
        SongDao songDao = new SongDaoImp();
        List<String> albums = songDao.getAlbums();

        assertEquals("album", albums.get(0));
        assertEquals("Húko", albums.get(1));
        assertEquals("Ostrava", albums.get(2));
        assertEquals("Assembly", albums.get(3));
        assertEquals("Húko", albums.get(1));
        assertEquals("Lusi", albums.get(4));
        assertEquals("Makeš", albums.get(5));
        assertEquals("Makeš", albums.get(5));
    }

    @Test
    public void getGenres() throws Exception {
        SongDao songDao = new SongDaoImp();
        List<String> genres = songDao.getGenres();

        assertEquals("genre", genres.get(0));
        assertEquals("speed metal", genres.get(1));
        assertEquals("slow metal", genres.get(2));
        assertEquals("pop", genres.get(3));
        assertEquals("speed metal", genres.get(1));
        assertEquals("pop", genres.get(3));
        assertEquals("rock", genres.get(4));
        assertEquals("rock", genres.get(4));
    }

}