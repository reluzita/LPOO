import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Folder extends Node {
    private List<Node> child;

    public Folder(FileSystem fs) {
        super(fs);
        child = new ArrayList<>();
    }

    public Folder(Folder parent, String name) throws DuplicateNameException {
        super(parent, name);
        child = new ArrayList<>();
    }

    public Node[] getChild() {
        Node[] temp = new Node[child.size()];
        return child.toArray(temp);
    }

    public void addChild(Node node) throws DuplicateNameException {
        if(getChildByName(node.getName()) != null)
            throw new DuplicateNameException();

        child.add(node);
    }

    public Node getChildByName(String name) {
        for(Node node: child) {
            if(node.getName().equals(name))
                return node;
        }
        return null;
    }

    @Override
    public int getSize() {
        int res = 0;
        for(Node node: child) {
            res += node.getSize();
        }
        return res;
    }

    public Folder clone(Folder parent, String name) throws DuplicateNameException {
        Folder newFolder = new Folder(parent, name);
        for(Node node: child) {
            if(node instanceof Folder) {
                ((Folder) node).clone(newFolder, node.getName());
            }
            else {
                ((File)node).clone(newFolder);
            }
        }
        return newFolder;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;

        if(!(o instanceof Folder))
            return false;

        Folder f = (Folder) o;
        return this.getName().equals(f.getName()) && Arrays.equals(this.getChild(), f.getChild());
    }

    public void removeChild(Node node) {
        child.remove(node);
    }
}

