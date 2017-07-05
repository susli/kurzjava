import com.mycompany.audiolibrary.Song;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by stepanmudra on 04.07.17.
 */
public class TestSong {

    Song song = new Song("Run to the hills", "Iron Maiden", "The number of the beast", 5, 1982, "Heavy metal", "3:52");
    @Test
    public void testGetName(){
        assertEquals("Run to the hills", song.getName());
    }
    @Test
    public void testGetInterpret(){
        assertEquals("Iron Maiden", song.getInterpret());
    }
    @Test
    public void testGetAlbum(){
        assertEquals("The number of the beast", song.getAlbum());
    }
    @Test
    public void testGetSongNumber(){
        assertEquals(5, song.getSongNumber());
    }
    @Test
    public void testGetYear(){
        assertEquals(1982, song.getYear());
    }
    @Test
    public void testGetGenre(){
        assertEquals("Heavy metal", song.getGenre());
    }
    @Test
    public void testGetLength(){
        assertEquals("3:52", song.getLength());
    }
    @Test
    public void testEquals(){
        Song song = new Song("IDK", "Nikoto", "Assembly", 12, 2014, "pop", "3:13");
        Song song1 = new Song("IDK", "Nikoto", "Assembly", 12, 2014, "pop", "3:13");
        Song song2 = new Song("Lálův song", "Franta Lála", "Lálovi Láloviny", 5, 2017, "rock", "3:13");
        assertTrue(song.equals(song));
        assertTrue(song.equals(song1));
        assertTrue(!song.equals(song2));
        assertTrue(song1.equals(song));
        assertTrue(song1.equals(song1));
        assertTrue(!song1.equals(song2));
        assertTrue(song2.equals(song2));
    }

}
