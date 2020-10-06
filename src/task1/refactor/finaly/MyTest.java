package task1.refactor.finaly;

import java.io.File;
import java.io.IOException;

public class MyTest {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/dima/Documents/Java projects/job4j/Middle/Блок 1 Multithreading /3. Синхронизация ресурсов/pom.xml");
        ParseFile parseFile = new ParseFile(file);
        System.out.println(parseFile.getContent(data -> (int) data < 0x80));
        parseFile.saveContent("example text");
    }
}
