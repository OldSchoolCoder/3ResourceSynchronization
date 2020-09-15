package task1.refactor.maybe;

import java.io.*;

public class WriteFile {
    private File file;

    public synchronized StringBuffer writeByte(int data) throws IOException {
        StringBuffer output = new StringBuffer();
        output.append((char) data);
        return output;
    }
}
