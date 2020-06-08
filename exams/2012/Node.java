import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Node {
    private FileSystem fs;
    private String name;
    private Folder parent;
    private static int number = 0;
    private int n;

    public Node(FileSystem fs) {
        this.fs = fs;
        this.name = "";
        this.parent = null;
        this.n = ++number;
    }

    public Node(Folder parent, String name) throws DuplicateNameException {
        this.fs = parent.getFs();
        this.parent = parent;
        this.name = name;
        this.n = ++number;

        parent.addChild(this);
    }

    public String getName() {
        return name;
    }

    public Node getParent() {
        return parent;
    }

    public static void resetNumbering(int n) {
        number = n;
    }

    public int getNumber() {
        return n;
    }

    public abstract int getSize();

    public FileSystem getFs() {
        return fs;
    }

    public String getPath() {
        if (parent == null)
            return "";
        return parent.getPath() + fs.getSeparator() + name;
    }

    public void move(Folder parent, String name) throws DuplicateNameException, CycleException {
        if(!this.parent.equals(parent)) {
            if(parent.equals(this))
                throw new CycleException();

            if(this instanceof Folder && ((Folder) this).getChildByName(parent.getName()) != null)
                throw new CycleException();

            this.parent.removeChild(this);
            this.parent = parent;
            parent.addChild(this);
        }
        if(!this.name.equals(name)) {
            this.name = name;
        }
    }
}
