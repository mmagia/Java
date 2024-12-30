import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try{
            AppManager test = new AppManager();
            test.runSimulation();

        } catch (IOException e) {
            System.exit(-1);
        }
    }
}
