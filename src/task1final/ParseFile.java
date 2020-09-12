package task1final;

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
        InputStream i = new FileInputStream(file);
        StringBuffer output = new StringBuffer();
        int data;
        while ((data = i.read()) != -1) {
            output.append((char) data);
        }
        i.close();
        return output;
    }

    public synchronized StringBuffer getContentWithoutUnicode() throws IOException {
        InputStream i = new FileInputStream(file);
        StringBuffer output = new StringBuffer();
        int data;
        while ((data = i.read()) != -1) {
            if (data < 0x80) {
                output.append((char) data);
            }
        }
        i.close();
        return output;
    }

    public synchronized void saveContent(String content) throws IOException {
        OutputStream o = new FileOutputStream(file);
        o.write(content.getBytes());
        o.close();
    }
}

