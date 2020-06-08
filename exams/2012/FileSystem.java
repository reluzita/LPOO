public class FileSystem {
    private String type;
    private Folder root;
    private NameFormatter nameFormatter;

    public FileSystem(String type) {
        this.type = type;
        this.root = new Folder(this);
    }

    public String getType() {
        return type;
    }

    public Folder getRoot() {
        return root;
    }

    public void setNameFormatter(NameFormatter nameFormatter) {
        this.nameFormatter = nameFormatter;
    }

    public char getSeparator() {
        return nameFormatter.getSeparator();
    }
}
