package task1.refactor.trash;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ReadFile {
    private File file;

    public synchronized int readByte(InputStream inputStream) throws IOException {
        //InputStream i = new FileInputStream(file);//нужно убрать т к открывает каждый раз заново и начитнает с начала
        //StringBuffer output = new StringBuffer();
        int data;
        data = inputStream.read();
        //i.close();//нужно убрать
        return data;
    }
}
