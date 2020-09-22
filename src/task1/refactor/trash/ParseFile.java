package task1.refactor.trash;

import java.io.*;

public class ParseFile {

    private File file;

    public synchronized void setFile(File f) {
        file = f;
    }

    public synchronized File getFile() {
        return file;
    }

    public synchronized StringBuffer getContent() throws IOException {
        ReadFile readFile = new ReadFile();
        WriteFile writeFile = new WriteFile();
        StringBuffer output = new StringBuffer();
        InputStream inputStream = new FileInputStream(file);
        int data;
        while ((data = readFile.readByte(inputStream)) != -1) {
            output=writeFile.writeByte(data);
        }
        inputStream.close();
        return output;
    }

    public synchronized StringBuffer getContentWithoutUnicode() throws IOException {
        ReadFile readFile = new ReadFile();
        WriteFile writeFile = new WriteFile();
        StringBuffer output = new StringBuffer();
        InputStream inputStream = new FileInputStream(file);
        int data;
        while ((data = readFile.readByte(inputStream)) != -1) {
            if (data < 0x80) {
                output=writeFile.writeByte(data);
            }
        }
        return output;
    }
}
