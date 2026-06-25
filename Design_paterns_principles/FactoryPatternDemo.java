public class FactoryPatternDemo {
    public static void main(String[] args) {
        FileCreator creatorA = new DocCreator();
        FileCreator creatorB = new PortableCreator();
        FileCreator creatorC = new SheetCreator();

        FileItem fileA = creatorA.createDocument();
        FileItem fileB = creatorB.createDocument();
        FileItem fileC = creatorC.createDocument();

        fileA.open();
        fileB.open();
        fileC.open();
    }
}

interface FileItem {
    void open();
}

class DocFile implements FileItem {
    @Override
    public void open() {
        System.out.println("Open Word");
    }
}

class PortableFile implements FileItem {
    @Override
    public void open() {
        System.out.println("Open PDF");
    }
}

class SheetFile implements FileItem {
    @Override
    public void open() {
        System.out.println("Open Excel");
    }
}

abstract class FileCreator {
    public abstract FileItem createDocument();
}

class DocCreator extends FileCreator {
    @Override
    public FileItem createDocument() {
        return new DocFile();
    }
}

class PortableCreator extends FileCreator {
    @Override
    public FileItem createDocument() {
        return new PortableFile();
    }
}

class SheetCreator extends FileCreator {
    @Override
    public FileItem createDocument() {
        return new SheetFile();
    }
}
