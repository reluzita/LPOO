import java.util.Arrays;

public class File extends Node {
    private int size;

    public File(Folder parent, String name) throws DuplicateNameException {
        super(parent, name);
        this.size = 0;
    }

    public File(Folder parent, String name, int size) throws DuplicateNameException {
        super(parent, name);
        this.size = size;
    }

    public int getSize(){
        return size;
    }

    public File clone(Folder parent) throws DuplicateNameException {
        return new File(parent, getName(), size);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;

        if(!(o instanceof File))
            return false;

        File f = (File) o;
        return this.getName().equals(f.getName()) && size == f.getSize();
    }
}
