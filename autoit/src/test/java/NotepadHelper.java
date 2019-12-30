import java.io.File;

public class NotepadHelper extends HelperBase {

    public NotepadHelper(AppManager manager) {
        super(manager);
    }

    public void typeASD() {
        aux.mouseClick("left", 118, 113, 1, 3);
        aux.send("asd");
    }

    public void saveFile(String title) throws InterruptedException {
        aux.mouseClick("left", 26,39, 1, 3);
        aux.mouseClick("left", 81,151, 1, 5);
        aux.send(title);
        Thread.sleep(1000);
        aux.mouseClick("left",506,500,1,5);
    }

    public boolean getSavedResult(String title) {
        File file = new File("C:\\Users\\Almaz\\Desktop\\Autoit_res\\" + title + ".txt");
        return file.exists();
    }
}
