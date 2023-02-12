import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class KeepTrack {
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
    private static LocalDateTime date = LocalDateTime.now();
    private static FileWriter writer;
    private static File keepTrack;

    private static String text;

    public static void main(String[] args) throws IOException {
        start();
        printTroubleshoot();
        printTroubleshoot();
    }

    public static void start() throws IOException {
        text = "";
        try {
            text = new String(Files.readAllBytes(Paths.get("C:\\CheckWarning_Software\\keepTrack.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        keepTrack = new File("C:\\CheckWarning_Software\\keepTrack.txt");
        writer = new FileWriter(keepTrack, true);
      //  text = "\n---- Software Being Turned On At "+dtf.format(date);
        writer.write(System.lineSeparator()+"---- Software Being Turned On At "+dtf.format(date));
        writer.close();
    }

    public static void printTroubleshoot() throws IOException {
        keepTrack = new File("C:\\CheckWarning_Software\\keepTrack.txt");
        writer = new FileWriter(keepTrack,true);
        date = LocalDateTime.now();
        text = System.lineSeparator()+"Troubleshooted at "+dtf.format(date);
        writer.write(text);
        writer.close();


    }
}
