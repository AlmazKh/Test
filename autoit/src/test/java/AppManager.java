import autoitx4java.AutoItX;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppManager {
    private NotepadHelper notepadHelper;
    private AutoItX aux;
    private String title;
    public static String TITLE = "Безымянный";

    public AppManager() {
        aux = new AutoItX();
        aux.run("notepad.exe", "C:\\Windows\\System32", AutoItX.SW_MAXIMIZE);
        aux.winWait(TITLE);
        aux.winActivate(TITLE);
        aux.winWaitActive(TITLE);
        notepadHelper = new NotepadHelper(this);
}

    public void stop() {
        if (title != null && !title.isEmpty()) {
            aux.winClose(aux.winGetTitle(title));
        } else {
            aux.winClose(TITLE);
        }
    }
}
