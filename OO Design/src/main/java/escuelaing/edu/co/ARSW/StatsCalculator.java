package escuelaing.edu.co.ARSW;

import java.util.List;

public class StatsCalculator {

    public static double mean(List<Double> data) {
        if (data == null || data.isEmpty())
            throw new IllegalArgumentException("La lista está vacía.");
        double sum = 0.0;
        for (double d : data) sum += d;
        return sum / data.size();
    }

    public static double sampleStdDev(List<Double> data) {
        if (data == null || data.size() < 2)
            throw new IllegalArgumentException("Se requieren al menos dos valores.");
        double avg = mean(data);
        double acc = 0.0;
        for (double d : data) {
            double diff = d - avg;
            acc += diff * diff;
        }
        double variance = acc / (data.size() - 1);
        return Math.sqrt(variance);
    }
}

