import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class AppManager {
    private Scanner scanner = new Scanner(System.in);
    private Map<Login, Password> userData = new HashMap<Login, Password>();
    private FileWriter bugWriter, userDataWriter;

    public void runSimulation() throws IOException{
        String enteredLine = "";
        try {
            userDataWriter = new FileWriter("loginPasswords.txt");
            bugWriter = new FileWriter("bugLogger.txt");
            while (true) {
                enteredLine = scanner.nextLine();
                if (enteredLine.equals("end")) {
                    break;
                }
                String cleanLine = enteredLine.trim().replaceAll(" +", " ").strip();
                String[] data = cleanLine.split(" ");
                try {
                    if (data.length != 2) {
                        throw new InvalidAmoutOfInputsException();
                    }
                } catch (InvalidAmoutOfInputsException e) {
                    bugWriter.write(e.getMessage());
                }

    
            }
        } catch (IOException e) {
            bugWriter.write("File is not found!");
            System.exit(-1);
        } finally {
            bugWriter.close();
            userDataWriter.close();
        }
    }
}
