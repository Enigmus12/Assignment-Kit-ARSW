package escuelaing.edu.co.ARSW;

import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Uso: mvn -q exec:java -Dexec.args=\"<ruta-archivo>\"");
            System.exit(1);
        }
        Path p = Paths.get(args[0]);
        MyLinkedList<Double> numbers = FileNumberReader.readDoubles(p);

        double mean = StatsCalculator.mean(numbers);
        double sd = StatsCalculator.sampleStdDev(numbers);

        System.out.printf("n=%d, media=%.2f, desv_est=%.2f%n", numbers.size(), mean, sd);
    }
}

