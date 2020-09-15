package task1.refactor.maybe;

import java.io.*;

public class ReadFile {
    private File file;

    public synchronized int readByte() throws IOException {
        InputStream i = new FileInputStream(file);
        StringBuffer output = new StringBuffer();
        int data;
        data = i.read();
        i.close();
        return data;
    }
}
