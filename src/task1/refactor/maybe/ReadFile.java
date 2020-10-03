package task1.refactor.maybe;

import java.io.*;

public class ReadFile {

    public synchronized int readByte(InputStream inputStream) throws IOException {
        int data;
        data = inputStream.read();
        return data;
    }
}
