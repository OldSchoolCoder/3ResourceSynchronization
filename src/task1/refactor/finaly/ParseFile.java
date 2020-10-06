package task1.refactor.finaly;
import java.io.*;
import java.util.function.Predicate;

public class ParseFile {

    private final File file;

    public ParseFile(final File file) {
        this.file = file;
    }

    public StringBuffer getContent(Predicate filter) throws IOException {
        ReadFile readFile = new ReadFile();
        WriteFile writeFile = new WriteFile();
        StringBuffer output = new StringBuffer();
        InputStream inputStream = new FileInputStream(file);
        int data;
        while ((data = readFile.readByte(inputStream)) != -1) {
            if (filter.test(data)) {
                output = writeFile.writeByte(data, output);
            }
        }
        inputStream.close();
        return output;
    }

    public synchronized void saveContent(String content) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(content.getBytes());
        fileOutputStream.close();
    }
}