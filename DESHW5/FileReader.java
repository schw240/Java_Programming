package DESHW5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {

//    List<String> lines;
//
//    public StringBuffer readFileLines(String filePath) throws IOException {
//
//        lines = Files.readAllLines(Paths.get(filePath) );
//
//        StringBuffer sb = new StringBuffer();  // 테스트용 변수
//
//        for(String line: lines) {
//            sb.append(line);
//        }
//        return sb;
//    }

    public byte[] readFileBytes(String filePath) throws IOException {
        return Files.readAllBytes(Paths.get(filePath));
    }

    public Boolean writeFileString(String filePath, String string) throws IOException {
        Path path = Files.write(Paths.get(filePath), string.getBytes());

        if (path == null) return false;
        else return true;
    }

    public Boolean writeFileBytes(String filePath, byte[] code) throws IOException {
        Path path = Files.write(Paths.get(filePath), code);

        if (path == null) return false;
        else return true;
    }

    public long size(String filePath) throws IOException {
        return Files.size(Paths.get(filePath));
    }
}
