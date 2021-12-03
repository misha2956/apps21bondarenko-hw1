package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    private final double avgTemp;
    private final double devTemp;
    private final double minTemp;
    private final double maxTemp;

    public TempSummaryStatistics() {
        this.avgTemp = 0;
        this.devTemp = 0;
        this.minTemp = 0;
        this.maxTemp = 0;
    }

    public TempSummaryStatistics(double avgTemp, double devTemp, double minTemp, double maxTemp) {
        this.avgTemp = avgTemp;
        this.devTemp = devTemp;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    double getAvgTemp() {
        return avgTemp;
    }

    double getDevTemp() {
        return devTemp;
    }

    double getMinTemp() {
        return minTemp;
    }

    double getMaxTemp() {
        return maxTemp;
    }

    boolean equals(TempSummaryStatistics other, double epsilon) {
        return Math.abs(avgTemp - other.getAvgTemp()) < epsilon &&
                Math.abs(devTemp - other.getDevTemp()) < epsilon &&
                Math.abs(minTemp - other.getMinTemp()) < epsilon &&
                Math.abs(maxTemp - other.getMaxTemp()) < epsilon;
    }

    @Override
    public String toString() {
        return "TempSummaryStatistics{" +
                "avgTemp=" + avgTemp +
                ", devTemp=" + devTemp +
                ", minTemp=" + minTemp +
                ", maxTemp=" + maxTemp +
                '}';
    }
}
