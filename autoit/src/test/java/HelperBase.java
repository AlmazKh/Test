import autoitx4java.AutoItX;

public class HelperBase {
    protected AppManager manager;
    protected String title;
    protected AutoItX aux;

    public HelperBase(AppManager manager){
        this.manager = manager;
        this.title = AppManager.TITLE;
        this.aux = manager.getAux();
    }
}
