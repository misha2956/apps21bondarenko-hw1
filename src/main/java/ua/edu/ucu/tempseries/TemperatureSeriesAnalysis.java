package ua.edu.ucu.tempseries;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {

    private static final double ZERO_KELVIN = -273D;
    private double[] temperatureSeries;
    private int size = 0;

    public TemperatureSeriesAnalysis() {
        this.temperatureSeries = new double[0];
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries)
            throws InputMismatchException {
        checkForImpossibleValues(temperatureSeries);
        this.temperatureSeries = temperatureSeries.clone();
        size = temperatureSeries.length;
    }

    private void checkForImpossibleValues(double[] temps)
            throws InputMismatchException {
        for (double temp : temps) {
            if (temp < ZERO_KELVIN) {
                throw new InputMismatchException(
                        "temperature is < 273 deg. cent."
                );
            }
        }
    }

    private void checkSeriesNonEmpty()throws IllegalArgumentException {
        if (size == 0 || temperatureSeries.length == 0) {
            throw new IllegalArgumentException("Series must not be empty");
        }
    }

    public double average() throws IllegalArgumentException {
        checkSeriesNonEmpty();
        double sum = 0;
        for (int i = 0; i < size; i++) {
            double temp = temperatureSeries[i];
            sum += temp;
        }
        return sum / size;
    }

    public double deviation() throws IllegalArgumentException {
        checkSeriesNonEmpty();
        if (size == 1) {
            return 0D;
        }
        double mean = this.average();
        double var = 0;
        for (int i = 0; i < size; i++) {
            double temp = temperatureSeries[i];
            var += (temp - mean) * (temp - mean);
        }
        var /= size - 1;
        return Math.sqrt(var);
    }

    public double min() throws IllegalArgumentException {
        checkSeriesNonEmpty();
        double ans = Double.POSITIVE_INFINITY;
        for (int i = 0; i < size; i++) {
            double temp = temperatureSeries[i];
            ans = Math.min(ans, temp);
        }
        return ans;
    }

    public double max() throws IllegalArgumentException {
        checkSeriesNonEmpty();
        double ans = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < size; i++) {
            double temp = temperatureSeries[i];
            ans = Math.max(ans, temp);
        }
        return ans;
    }

    public double findTempClosestToZero() {
        checkSeriesNonEmpty();
        double ans = Double.POSITIVE_INFINITY;
        for (int i = 0; i < size; i++) {
            double temp = temperatureSeries[i];
            ans = (Math.abs(temp) > Math.abs(ans)) ? ans : (
                    (Math.abs(temp+ans) < Double.MIN_VALUE) ?
                            (Math.max(temp, ans)) : temp
            );
        }
        return ans;
    }

    public double findTempClosestToValue(double tempValue) {
        checkSeriesNonEmpty();
        double ans = Double.POSITIVE_INFINITY;
        for (int i = 0; i < size; i++) {
            double temp = temperatureSeries[i];
            ans = (
                    Math.abs(temp-tempValue) > Math.abs(ans-tempValue)
            ) ? ans : (
                    (Math.abs(tempValue*2-temp-ans) < Double.MIN_VALUE) ?
                            (Math.max(temp, ans)) : temp
            );
        }
        return ans;
    }

    public double[] findTempsLessThen(double tempValue) {
        int len = 0;
        for (int i = 0; i < size; i++) {
            double temp = temperatureSeries[i];
            len += (temp < tempValue) ? 1 : 0;
        }
        double[] ans = new double[len];
        int ai = 0;
        for (int i = 0; i < size; i++) {
            double temp = temperatureSeries[i];
            if (temp < tempValue) {
                ans[ai++] = temp;
            }
        }
        return ans;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        int len = 0;
        for (int i = 0; i < size; i++) {
            double temp = temperatureSeries[i];
            len += (temp >= tempValue) ? 1 : 0;
        }
        double[] ans = new double[len];
        int ai = 0;
        for (int i = 0; i < size; i++) {
            double temp = temperatureSeries[i];
            if (temp >= tempValue) {
                ans[ai++] = temp;
            }
        }
        return ans;
    }

    public TempSummaryStatistics summaryStatistics() {
        checkSeriesNonEmpty();
        return new TempSummaryStatistics(
                this.average(), this.deviation(), this.min(), this.max()
        );
    }

    private void doubleCap() {
        double[] tempsNew = new double[temperatureSeries.length * 2];
        System.arraycopy(
                temperatureSeries, 0, tempsNew, 0, temperatureSeries.length
        );
        temperatureSeries = tempsNew;
    }

    public int addTemps(double... temps) throws InputMismatchException {
        checkForImpossibleValues(temps);
        for (double temp : temps) {
            if (size == temperatureSeries.length) {
                doubleCap();
            }
            temperatureSeries[size++] = temp;
        }
        return size;
    }
}
