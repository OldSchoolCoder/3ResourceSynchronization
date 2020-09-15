package task1.refactor.maybe;

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
        int data;
        while ((data = readFile.readByte()) != -1) {
            output = writeFile.writeByte(data);
        }
        return output;
    }

    public synchronized StringBuffer getContentWithoutUnicode() throws IOException {
        ReadFile readFile = new ReadFile();
        WriteFile writeFile = new WriteFile();
        StringBuffer output = new StringBuffer();
        int data;
        while ((data = readFile.readByte()) != -1) {
            if (data < 0x80) {
                output = writeFile.writeByte(data);
            }
        }
        return output;
    }

    public synchronized void saveContent(String content) throws IOException {
        OutputStream o = new FileOutputStream(file);
        o.write(content.getBytes());
        o.close();
    }
}
