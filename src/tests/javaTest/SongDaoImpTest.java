import com.mycompany.audiolibrary.Song;
import com.mycompany.audiolibrary.SongDao;
import com.mycompany.audiolibrary.SongDaoImpl;
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
        SongDao songDao = new SongDaoImpl();
        List<Song> songs = songDao.findAll();
        Song song;

        song = new Song("Motor", "Corko", "Húko", 12, 1999, "speed metal", "12:12");
        assertTrue(song.equals(songs.get(0)));

        song = new Song("Netuší", "Lopata", "Ostrava", 12, 2015, "slow metal", "16:33");
        assertTrue(song.equals(songs.get(1)));

        song = new Song("Vyprchává", "Nikoto", "Assembly", 12, 2014, "pop", "3:13");
        assertTrue(song.equals(songs.get(2)));

        song = new Song("Maybe", "Heyja", "Húko", 6, 1999, "speed metal", "4:50");
        assertTrue(song.equals(songs.get(3)));

        song = new Song("Despacito", "Lusi", "WhAt", 3, 2017, "pop", "4:51");
        assertTrue(song.equals(songs.get(4)));

        song = new Song("Kdo to ví?", "Kura", "Makeš", 2, 2012, "rock", "5:40");
        assertTrue(song.equals(songs.get(5)));

        song = new Song("Posel", "Mezinkoš", "Makeš", 3, 2017, "rock", "4:13");
        assertTrue(song.equals(songs.get(6)));

        song = new Song();
        assertTrue(!song.equals(songs.get(6)));
    }

    @Test
    public void findByAlbum() throws Exception {
        SongDao songDao = new SongDaoImpl();
        List<Song> songs = songDao.findByAlbum("Húko");
        Song song = new Song("Motor", "Corko", "Húko", 12, 1999, "speed metal", "12:12");
        Song song1 = new Song("Maybe", "Heyja", "Húko", 6, 1999, "speed metal", "4:50");

        assertTrue(song.equals(songs.get(0)));
        assertTrue(song1.equals(songs.get(1)));
    }

    @Test
    public void findByInterpret() throws Exception {
        SongDao songDao = new SongDaoImpl();
        Song song = new Song("Maybe", "Heyja", "Húko", 6, 1999, "speed metal", "4:50");
        Song song1 = new Song("Kdo to ví?", "Kura", "Makeš", 2, 2012, "rock", "5:40");
        List<Song> songs = songDao.findByInterpret("Heyja");

        assertTrue(song.equals(songs.get(0)));
        assertTrue(!song1.equals(songs.get(0)));
    }

    @Test
    public void findByGenre() throws Exception {
        SongDao songDao = new SongDaoImpl();
        List<Song> songs = songDao.findByGenre("pop");
        Song song = new Song("Vyprchává", "Nikoto", "Assembly", 12, 2014, "pop", "3:13");
        Song song1 = new Song("Despacito", "Lusi", "WhAt", 3, 2017, "pop", "4:51");

        assertTrue(song.equals(songs.get(0)));
        assertTrue(song1.equals(songs.get(1)));
    }

    @Test
    public void findByYear() throws Exception {
        SongDao songDao = new SongDaoImpl();
        List<Song> songs = songDao.findByYear(2014);
        Song song = new Song("Vyprchává", "Nikoto", "Assembly", 12, 2014, "pop", "3:13");

        assertTrue(song.equals(songs.get(0)));
    }

    @Test
    public void findbyName() throws Exception {
        SongDao songDao = new SongDaoImpl();
        List<Song> songs = songDao.findByName("Maybe");
        Song song = new Song("Maybe", "Heyja", "Húko", 6, 1999, "speed metal", "4:50");

        assertTrue(song.equals(songs.get(0)));
    }

    @Test
    public void getInterprets() throws Exception {
        SongDao songDao = new SongDaoImpl();
        List<String> interprets = songDao.getInterprets();

        assertEquals("Corko", interprets.get(0));
        assertEquals("Lopata", interprets.get(1));
        assertEquals("Nikoto", interprets.get(2));
        assertEquals("Heyja", interprets.get(3));
        assertEquals("Lusi", interprets.get(4));
        assertEquals("Kura", interprets.get(5));
        assertEquals("Mezinkoš", interprets.get(6));
    }

    @Test
    public void getYears() throws Exception {
        SongDao songDao = new SongDaoImpl();
        List<String> years = songDao.getYears();

        assertEquals("1999", years.get(0));
        assertEquals("2015", years.get(3));
        assertEquals("2014", years.get(2));
        assertEquals("1999", years.get(0));
        assertEquals("2017", years.get(4));
        assertEquals("2012", years.get(1));
        assertEquals("2017", years.get(4));
    }

    @Test
    public void getAlbums() throws Exception {
        SongDao songDao = new SongDaoImpl();
        List<String> albums = songDao.getAlbums();

        assertEquals("Húko", albums.get(0));
        assertEquals("Ostrava", albums.get(1));
        assertEquals("Assembly", albums.get(2));
        assertEquals("Húko", albums.get(0));
        assertEquals("WhAt", albums.get(3));
        assertEquals("Makeš", albums.get(4));
        assertEquals("Makeš", albums.get(4));
    }

    @Test
    public void getGenres() throws Exception {
        SongDao songDao = new SongDaoImpl();
        List<String> genres = songDao.getGenres();

        assertEquals("speed metal", genres.get(0));
        assertEquals("slow metal", genres.get(1));
        assertEquals("pop", genres.get(2));
        assertEquals("speed metal", genres.get(0));
        assertEquals("pop", genres.get(2));
        assertEquals("rock", genres.get(3));
        assertEquals("rock", genres.get(3));
    }

}