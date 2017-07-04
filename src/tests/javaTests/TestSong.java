import com.mycompany.audiolibrary.Song;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by stepanmudra on 04.07.17.
 */
public class TestSong extends TestCase{

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

}
