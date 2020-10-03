package task1.refactor.maybe;

import java.io.*;

public class WriteFile {

    public synchronized StringBuffer writeByte(int data, StringBuffer output) throws IOException {
        output.append((char) data);
        return output;
    }
}
