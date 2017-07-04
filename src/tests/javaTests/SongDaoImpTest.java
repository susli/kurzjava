import com.mycompany.audiolibrary.Song;
import com.mycompany.audiolibrary.SongDao;
import com.mycompany.audiolibrary.SongDaoImp;
import org.junit.Test;

import java.util.List;

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
    }

    @Test
    public void findByGenre() throws Exception {
    }

    @Test
    public void findByYear() throws Exception {
    }

    @Test
    public void findbyName() throws Exception {
    }

    @Test
    public void getInterprets() throws Exception {
    }

    @Test
    public void getYears() throws Exception {
    }

    @Test
    public void getAlbums() throws Exception {
    }

    @Test
    public void getGenres() throws Exception {
    }

}