package fotoslideshow.objects;

import java.io.File;
import java.util.List;
import java.util.ArrayList;

public class Folder extends File {

    private List<File> folder;
    private List<File> imagesOnly;

    public Folder(String path) throws Exception {
        super(path);
        this.folder = new ArrayList<File>();
        addAllFiles();
        this.imagesOnly = new ArrayList<File>();
        addImages();
    }

    /**
     * the basic method to add files to the first list (all objects in the given
     * folder)
     *
     * @param file
     */
    private void addFile(File file) {
        this.folder.add(file.getAbsoluteFile());
    }

    /**
     * adds all files in the given folder to the list with all files
     */
    private void addAllFiles() {
        for (File file : super.listFiles()) {
            addFile(file);
        }
    }

    /**
     * for each file in the first list, it determines if it is an image then the
     * image gets added to the working list
     */
    private void addImages() {
        for (File file : this.folder) {
            if (file.getAbsolutePath().substring(file.getAbsolutePath().length() - 4).matches(".jpg|.JPG|jpeg|JPEG|.bmp|.BMP|.tif|.TIF|.png|.PNG")) {
                this.imagesOnly.add(file);
            }
        }
    }

    /**
     * get the size of the "all inclusive" list
     *
     * @return
     */
    public int getFolderNumberOfElements() {
        return this.folder.size();
    }

    /**
     * get the size of the images only list
     *
     * @return
     */
    public int getFolderNumberOfImages() {
        return this.imagesOnly.size();
    }

    /**
     * gets the images only list
     *
     * @return list imagesOnly
     */
    public List<File> getListImagesOnly() {
        return this.imagesOnly;
    }
}
