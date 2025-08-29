package escuelaing.edu.co.ARSW;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileNumberReader {
    public static MyLinkedList<Double> readDoubles(Path path) throws IOException {
        MyLinkedList<Double> list = new MyLinkedList<>();
        try (Stream<String> lines = Files.lines(path)) {
            lines.map(String::trim)
                 .filter(s -> !s.isEmpty())
                 .forEach(s -> {
                     for (String tok : s.split("[,\\s]+")) {
                         if (!tok.isEmpty()) list.add(Double.parseDouble(tok));
                     }
                 });
        }
        return list;
    }
}
