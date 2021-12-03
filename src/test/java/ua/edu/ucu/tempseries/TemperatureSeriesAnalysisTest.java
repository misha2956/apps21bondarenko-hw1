package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {

    private final double epsilon = 0.00001;

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, epsilon);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, epsilon);
    }

    @Test
    public void testDeviationWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0;
        double actualResult = seriesAnalysis.deviation();
        assertEquals(expResult, actualResult, epsilon);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.deviation();
    }

    @Test
    public void testDeviation() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 4.320494;
        double actualResult = seriesAnalysis.deviation();
        assertEquals(expResult, actualResult, epsilon);
    }

    @Test
    public void testMinWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1D;
        double actualResult = seriesAnalysis.min();
        assertEquals(expResult, actualResult, epsilon);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.min();
    }

    @Test
    public void testMin() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -5D;
        double actualResult = seriesAnalysis.min();
        assertEquals(expResult, actualResult, epsilon);
    }

    @Test
    public void testMaxWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1D;
        double actualResult = seriesAnalysis.max();
        assertEquals(expResult, actualResult, epsilon);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.max();
    }

    @Test
    public void testMax() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 5D;
        double actualResult = seriesAnalysis.max();
        assertEquals(expResult, actualResult, epsilon);
    }

    @Test
    public void testFindTempClosestToZeroWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1D;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, epsilon);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToZeroWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.findTempClosestToZero();
    }

    @Test
    public void testFindTempClosestToZero() {
        double[] temperatureSeries = {3.0, -5.0, -1.0, 1.0, 5.0, -1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1D;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, epsilon);
    }

    @Test
    public void testFindTempClosestToValueWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1D;
        double actualResult = seriesAnalysis.findTempClosestToValue(2);
        assertEquals(expResult, actualResult, epsilon);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToValueWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.findTempClosestToValue(2);
    }

    @Test
    public void testFindTempClosestToValue() {
        double[] temperatureSeries = {-5.0, 1.0, 3.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 3D;
        double actualResult = seriesAnalysis.findTempClosestToValue(2);
        assertEquals(expResult, actualResult, epsilon);
    }

    @Test
    public void testFindTempsLessThenWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-1.0};
        double[] actualResult = seriesAnalysis.findTempsLessThen(2);
        assertArrayEquals(expResult, actualResult, epsilon);
    }

    @Test
    public void testFindTempsLessThen() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 3.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-5D, 1D, 1D};
        double[] actualResult = seriesAnalysis.findTempsLessThen(2);
        assertArrayEquals(expResult, actualResult, epsilon);
    }

    @Test
    public void testFindTempsGreaterThenWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-1.0};
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(-1D);
        assertArrayEquals(expResult, actualResult, epsilon);
    }

    @Test
    public void testFindTempsGreaterThen() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 3.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {3D, 3D, 5D};
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(3D);
        assertArrayEquals(expResult, actualResult, epsilon);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSummaryStatisticsWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.summaryStatistics();
    }

    @Test
    public void testSummaryStatistics() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        TempSummaryStatistics expResult = new TempSummaryStatistics(1D, 4.320494, -5D, 5D);
        TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();
        assertTrue(expResult.equals(actualResult, epsilon));
    }

    @Test
    public void testAddTemps() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        assertEquals(8, seriesAnalysis.addTemps(3.0, -5.0, 1.0, 5.0));
        double[] newTemperatureSeries = {3.0, -5.0, 1.0, 5.0, 3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis newSeriesAnalysis = new TemperatureSeriesAnalysis(newTemperatureSeries);
        assertTrue(newSeriesAnalysis.summaryStatistics().equals(seriesAnalysis.summaryStatistics(), epsilon));
    }

    @Test(expected = InputMismatchException.class)
    public void testAddTempsWithImpossibleValues() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.addTemps(3.0, -499D);
    }
}
