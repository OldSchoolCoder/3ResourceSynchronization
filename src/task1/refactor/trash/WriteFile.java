package task1.refactor.trash;

import java.io.*;

public class WriteFile {
    private File file;

    public synchronized StringBuffer writeByte(int data) throws IOException {
        StringBuffer output = new StringBuffer();//нужно убрать т к открывает каждый раз заново и начитнает с начал/
        output.append((char) data);
        return output;
    }
}
