package HW4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {

    List<String> lines;

    public StringBuffer readFileLines(String filePath) throws IOException {

        lines = Files.readAllLines(Paths.get(filePath) );

        StringBuffer sb = new StringBuffer();  // 테스트용 변수

        for(String line: lines) {
            sb.append(line);
        }
        return sb;
    }
}
