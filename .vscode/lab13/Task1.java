import java.util.ArrayList;
import java.util.List;


public class Task1 {
    public static void main(String[] args) {
        final int test = 1000;
        LibraryGenerics<Book> booksLibrary = new LibraryGenerics<>();
        LibraryGenerics<Video> videoLibrary = new LibraryGenerics<>();
        LibraryGenerics<Newspaper> newspaperLibrary = new LibraryGenerics<>();
        Book harryPotter = new Book(test, "Harry Potter");
        Video javaTutorial = new Video(test, "Java Tutorial");
        Newspaper cosmopolitan = new Newspaper(test, "Cosmopolitan");
        booksLibrary.addInformationSource(harryPotter);
        booksLibrary.openSource(0);
        booksLibrary.closeSource(0);
        videoLibrary.addInformationSource(javaTutorial);
        newspaperLibrary.addInformationSource(cosmopolitan);
        booksLibrary.deleteInformation(test);
        LibraryNoGenericsBook testLibrary = new LibraryNoGenericsBook();
        testLibrary.add(harryPotter);
        testLibrary.listBooks();
        testLibrary.delete(0);
        testLibrary.listBooks();
    }
}


class Author {
    private String name = "unknown";
    private int age = -1;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}

abstract class Media {
    private String sourceType;
    private String sourceName;
    private Author author;
    private boolean open;
    public Media(String sourceType, boolean open, String sourceName) {
        this.sourceType = sourceType;
        this.sourceName = sourceName;
        this.open = open;
    }


    public void displayStatus() {
        System.out.println(getsourceType() + " " + getsourceName()
        + " and the opening status is " + isOpen());
    }

    public void setsourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public void setAuthor(String name, int age) {
        this.author.setAge(age);
        this.author.setName(name);
    }

    public Author getAuthor() {
        return this.author;
    }

    public String getsourceType() {
        return sourceType;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isOpen() {
        return this.open;
    }

    public void openSource() {
        if (open) {
            System.out.println(getsourceType() + " " + getsourceName() + " is already open");
        } else {
            this.open = true;
            System.out.println(getsourceType() + " " + getsourceName() + " is opened");
        }
    }

    public void closeSource() {
        if (!open) {
            System.out.println(getsourceType() + " " + getsourceName() + " is already closed");
        } else {
            this.open = false;
            System.out.println(getsourceType() + " " + getsourceName() + " is closed");
        }
    }

    public String getsourceName() {
        return this.sourceName;
    }
    public abstract void getInformation();
}

class Book extends Media {
    private int amountOfPages;
    private int page = 1;
    public Book(int amountOfPages, String bookName) {
        super("Book", false, bookName);
        this.amountOfPages = amountOfPages;
    }

    @Override
    public void getInformation() {
        System.out.println("You are reading " + page + " page of book " + getsourceName());
        page++;
    }
}

class Video extends Media {
    private int duration;
    private int minute = 1;
    public Video(int minute, String videoName) {
        super("Video", false, videoName);
        this.duration = duration;
    }

    @Override
    public void getInformation() {
        System.out.println("You are watching " + minute + " minute of video " + getsourceName());
        minute++;
    }
}

class Newspaper extends Media {
    private int volume;
    private int page = 1;
    public Newspaper(int volume, String newspaperName) {
        super("Newspaper", false, newspaperName);
        this.volume = volume;
    }

    @Override
    public void getInformation() {
        System.out.println("You are reading " + page + " page of newspaper " + getsourceName());
        page++;
    }
}


class LibraryGenerics<T extends Media> {
    private List<T> collection = new ArrayList<>();
    public void addInformationSource(T source) {
        if (!collection.contains(source)) {
            collection.add(source);
            System.out.println(source.getsourceType() + " " + source.getsourceName() + " added");
        } else {
            System.out.println("This source is already in library!");
        }
    }

    public void deleteInformation(int index) {
        if (index < 0 || index > collection.size()) {
            System.out.println("No such element in this library");
        } else {
            System.out.println(collection.get(index).getsourceType() + " "
            + collection.get(index).getsourceName() + " added");
            collection.remove(index);
        }

    }

    public void useSource(int index) {
        if (collection.get(index).isOpen()) {
            collection.get(index).getInformation();
        } else {
            System.out.println("You can not access closed source!");
        }
    }

    public void openSource(int index) {
        collection.get(index).openSource();
    }

    public void closeSource(int index) {
        collection.get(index).closeSource();
    }
}

class LibraryNoGenericsBook {
    private static int initialAmountOfBooks = 0;
    private static Media[] books = new Media[initialAmountOfBooks];

    public void listBooks() {
        for (int i = 0; i < initialAmountOfBooks; i++) {
            ((Book) books[i]).displayStatus();
        }
    }

    private void makeBook() {
        for (int i = 0; i < initialAmountOfBooks; i++) {
            books[i] = (Book) books[i];
        }
    }

    public void add(Media object) {
        Media[] newArray = new Media[books.length + 1];
        for (int i = 0; i < books.length; i++) {
            newArray[i] = books[i];
        }
        newArray[newArray.length - 1] = object;
        books = newArray;
        initialAmountOfBooks += 1;
        makeBook();
    }

    public void delete(int index) {
        Media[] newArray = new Media[books.length - 1];
        for (int i = 0; i < index; i++) {
            newArray[i] = books[i];
        }
        for (int i = index; i < books.length - 1; i++) {
            newArray[i] = books[i + 1];
        }
        books = newArray;
        initialAmountOfBooks -= 1;
        makeBook();
    }
}


class LibraryNoGenericsVideo {
    private static int initialAmountOfVideo = 0;
    private static Media[] video = new Media[initialAmountOfVideo];

    public void listVideo() {
        for (int i = 0; i < initialAmountOfVideo; i++) {
            ((Video) video[i]).displayStatus();
        }
    }

    private void makeVideo() {
        for (int i = 0; i < initialAmountOfVideo; i++) {
            video[i] = (Video) video[i];
        }
    }

    public void add(Media object) {
        Media[] newArray = new Media[video.length + 1];
        for (int i = 0; i < video.length; i++) {
            newArray[i] = video[i];
        }
        newArray[newArray.length - 1] = object;
        video = newArray;
        makeVideo();
    }

    public void delete(int index) {
        Media[] newArray = new Media[video.length - 1];
        for (int i = 0; i < index; i++) {
            newArray[i] = video[i];
        }
        for (int i = index; i < video.length - 1; i++) {
            newArray[i] = video[i + 1];
        }
        video = newArray;
        makeVideo();
    }
}


class LibraryNoGenericsNewspaper {
    private static int initialAmountOfNewspaper = 0;
    private static Media[] newspapers = new Media[initialAmountOfNewspaper];

    public void listVideo() {
        for (int i = 0; i < initialAmountOfNewspaper; i++) {
            ((Video) newspapers[i]).displayStatus();
        }
    }

    private void makeNewspaper() {
        for (int i = 0; i < initialAmountOfNewspaper; i++) {
            newspapers[i] = (Newspaper) newspapers[i];
        }
    }

    public void add(Media object) {
        Media[] newArray = new Media[newspapers.length + 1];
        for (int i = 0; i < newspapers.length; i++) {
            newArray[i] = newspapers[i];
        }
        newArray[newArray.length - 1] = object;
        newspapers = newArray;
        makeNewspaper();
    }

    public void delete(int index) {
        Media[] newArray = new Media[newspapers.length - 1];
        for (int i = 0; i < index; i++) {
            newArray[i] = newspapers[i];
        }
        for (int i = index; i < newspapers.length - 1; i++) {
            newArray[i] = newspapers[i + 1];
        }
        newspapers = newArray;
        makeNewspaper();
    }
}

