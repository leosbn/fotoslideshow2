package fotoslideshow.objects;

import java.io.File;
import java.util.List;
import java.util.ArrayList;

public class Folder extends File {

    private List<File> folder;
    private List<File> imagesOnly;

    public Folder(String path) {
        super(path);
        this.folder = new ArrayList<File>();
        addAllFiles();
        this.imagesOnly = new ArrayList<File>();
        addImages();
    }

    private void addFile(File file) {
        this.folder.add(file.getAbsoluteFile());
    }

    private void addAllFiles() {
        for (File file : super.listFiles()) {
            addFile(file);
        }
    }

    private void addImages() {
        for (File file : this.folder) {
            if (file.getAbsolutePath().substring(file.getAbsolutePath().length() - 4).matches(".jpg|.JPG|jpeg|JPEG|.bmp|.BMP|.tif|.TIF")) {
                this.imagesOnly.add(file);
            }
        }
    }

    public int getFolderNumberOfElements() {
        return this.folder.size();
    }

    public int getFolderNumberOfImages() {
        return this.imagesOnly.size();
    }
    
    public List<File> getListImagesOnly(){
        return this.imagesOnly;
    }
}
