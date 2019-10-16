package fotoslideshow.objects;

import java.io.File;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FolderTest {

    public FolderTest() {
    }

    /**
     * Test of getFolderNumberOfElements method, of class Folder.
     */
    @Test
    public void testGetFolderNumberOfElements() {
        Folder instance = new Folder(""); //add your own testing folder here
        int result = instance.getFolderNumberOfElements();
        File f = new File(""); //add your own testing folder here
        assertEquals(f.list().length, result);
    }

    /**
     * Test of getFolderNumberOfImages method, of class Folder.
     */
    @Test
    public void testGetFolderNumberOfImages() {
        Folder instance = new Folder(""); //add your own testing folder here
        int result = instance.getFolderNumberOfImages();
        assertEquals(10, result);
    }

    /**
     * Test of getListImagesOnly method, of class Folder. how do i pass this
     * kind of test?
     */
    @Test
    public void testGetListImagesOnly() {
        System.out.println("getListImagesOnly");
        Folder instance = new Folder(""); //add your own testing folder here
        List<File> result = instance.getListImagesOnly();
        assertEquals(10, result.size());
    }

}
