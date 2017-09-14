import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {
        private String fileName;
        private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void init() throws IOException {
        if (file.canWrite())
        this.file = new File(fileName);
    }

    public void logEvent(Event event) {

    }
}
