package task1.refactor.maybe;

import java.io.*;

public class ParseFile {

    private final File file;

    public ParseFile(final File file) {
        this.file = file;
    }

    public StringBuffer getContent() throws IOException {
        ReadFile readFile = new ReadFile();
        WriteFile writeFile = new WriteFile();
        StringBuffer output = new StringBuffer();
        InputStream inputStream = new FileInputStream(file);
        int data;
        while ((data = readFile.readByte(inputStream)) != -1) {
            output = writeFile.writeByte(data, output);
        }
        inputStream.close();
        return output;
    }

    public StringBuffer getContentWithoutUnicode() throws IOException {
        ReadFile readFile = new ReadFile();
        WriteFile writeFile = new WriteFile();
        StringBuffer output = new StringBuffer();
        InputStream inputStream = new FileInputStream(file);
        int data;
        while ((data = readFile.readByte(inputStream)) != -1) {
            if (data < 0x80) {
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