package escuelaing.edu.co.ARSW;

import org.junit.jupiter.api.Test;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class StatsCalculatorTest {

    @Test
    void column1_values_match_expected() {
        MyLinkedList<Double> data = new MyLinkedList<>();
        double[] arr = {160,591,114,229,230,270,128,1657,624,1503};
        for (double d : arr) data.add(d);

        assertEquals(550.6, StatsCalculator.mean(data), 0.01);
        assertEquals(572.03, StatsCalculator.sampleStdDev(data), 0.01);
    }

    @Test
    void column2_from_file_values_match_expected() throws Exception {
        URI uri = getClass().getResource("/column2.txt").toURI();
        Path path = Paths.get(uri);
        MyLinkedList<Double> data = FileNumberReader.readDoubles(path);

        assertEquals(10, data.size());
        assertEquals(60.32, StatsCalculator.mean(data), 0.01);
        assertEquals(62.26, StatsCalculator.sampleStdDev(data), 0.01);
    }
}

