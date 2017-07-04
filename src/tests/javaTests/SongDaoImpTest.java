import com.mycompany.audiolibrary.Song;
import com.mycompany.audiolibrary.SongDao;
import com.mycompany.audiolibrary.SongDaoImp;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by stepanmudra on 04.07.17.
 */
public class SongDaoImpTest{
    SongDao songDao = new SongDaoImp();
    @Test
    public void findAll() throws Exception {
        List<Song> songs = songDao.findAll();
        Song song = new Song();

        assertEquals(song.getName(), songs.get(0).getName());
        assertEquals(song.getAlbum(), songs.get(0).getAlbum());
        assertEquals(song.getGenre(), songs.get(0).getGenre());
        assertEquals(song.getInterpret(), songs.get(0).getInterpret());
        assertEquals(song.getSongNumber(), songs.get(0).getSongNumber());
        assertEquals(song.getYear(), songs.get(0).getYear());
        assertEquals(song.getLength(), songs.get(0).getLength());

        song = new Song("IDK", "Corko", "Húko", 12, 1999, "speed metal", "12:12");
        assertEquals(song.getName(), songs.get(1).getName());
        assertEquals(song.getAlbum(), songs.get(1).getAlbum());
        assertEquals(song.getGenre(), songs.get(1).getGenre());
        assertEquals(song.getInterpret(), songs.get(1).getInterpret());
        assertEquals(song.getSongNumber(), songs.get(1).getSongNumber());
        assertEquals(song.getYear(), songs.get(1).getYear());
        assertEquals(song.getLength(), songs.get(1).getLength());

        song = new Song("Netuším", "Lopata", "Ostrava", 12, 2015, "slow metal", "16:33");
        assertEquals(song.getName(), songs.get(2).getName());
        assertEquals(song.getAlbum(), songs.get(2).getAlbum());
        assertEquals(song.getGenre(), songs.get(2).getGenre());
        assertEquals(song.getInterpret(), songs.get(2).getInterpret());
        assertEquals(song.getSongNumber(), songs.get(2).getSongNumber());
        assertEquals(song.getYear(), songs.get(2).getYear());
        assertEquals(song.getLength(), songs.get(2).getLength());

        song = new Song("IDK", "Nikoto", "Assembly", 12, 2014, "pop", "3:13");
        assertEquals(song.getName(), songs.get(3).getName());
        assertEquals(song.getAlbum(), songs.get(3).getAlbum());
        assertEquals(song.getGenre(), songs.get(3).getGenre());
        assertEquals(song.getInterpret(), songs.get(3).getInterpret());
        assertEquals(song.getSongNumber(), songs.get(3).getSongNumber());
        assertEquals(song.getYear(), songs.get(3).getYear());
        assertEquals(song.getLength(), songs.get(3).getLength());

        song = new Song("Možná", "Heyja", "Húko", 6, 1999, "speed metal", "4:50");
        assertEquals(song.getName(), songs.get(4).getName());
        assertEquals(song.getAlbum(), songs.get(4).getAlbum());
        assertEquals(song.getGenre(), songs.get(4).getGenre());
        assertEquals(song.getInterpret(), songs.get(4).getInterpret());
        assertEquals(song.getSongNumber(), songs.get(4).getSongNumber());
        assertEquals(song.getYear(), songs.get(4).getYear());
        assertEquals(song.getLength(), songs.get(4).getLength());

        song = new Song("Jako", "Despacito", "Lusi", 3, 2017, "pop", "4:51");
        assertEquals(song.getName(), songs.get(5).getName());
        assertEquals(song.getAlbum(), songs.get(5).getAlbum());
        assertEquals(song.getGenre(), songs.get(5).getGenre());
        assertEquals(song.getInterpret(), songs.get(5).getInterpret());
        assertEquals(song.getSongNumber(), songs.get(5).getSongNumber());
        assertEquals(song.getYear(), songs.get(5).getYear());
        assertEquals(song.getLength(), songs.get(5).getLength());

        song = new Song("Jako", "Kura", "Makeš", 2, 2012, "rock", "5:40");
        assertEquals(song.getName(), songs.get(6).getName());
        assertEquals(song.getAlbum(), songs.get(6).getAlbum());
        assertEquals(song.getGenre(), songs.get(6).getGenre());
        assertEquals(song.getInterpret(), songs.get(6).getInterpret());
        assertEquals(song.getSongNumber(), songs.get(6).getSongNumber());
        assertEquals(song.getYear(), songs.get(6).getYear());
        assertEquals(song.getLength(), songs.get(6).getLength());

        song = new Song("IDK", "Mezinkoš", "Makeš", 3, 2017, "rock", "4:13");
        assertEquals(song.getName(), songs.get(7).getName());
        assertEquals(song.getAlbum(), songs.get(7).getAlbum());
        assertEquals(song.getGenre(), songs.get(7).getGenre());
        assertEquals(song.getInterpret(), songs.get(7).getInterpret());
        assertEquals(song.getSongNumber(), songs.get(7).getSongNumber());
        assertEquals(song.getYear(), songs.get(7).getYear());
        assertEquals(song.getLength(), songs.get(7).getLength());
    }

    @Test
    public void findByAlbum() throws Exception {
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