import java.io.*;

public class FileEventLogger implements EventLogger {
        private String fileName;
        private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void init() throws IOException {
        file = new File(fileName);
        if (file.exists() && !file.canWrite()) {
            throw new IllegalArgumentException("Can't write to file " + fileName);
        } else if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                throw new IllegalArgumentException("Can't create file", e);
            }

        }
    }

    public void logEvent(Event event) {
        try {
            BufferedWriter buffered = new BufferedWriter(new FileWriter(file));
            buffered.write(event.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
