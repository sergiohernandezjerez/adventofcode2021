package day1SonarSweep;

import java.io.FileNotFoundException;

public class Dday1 {
    public static void main(String[] args) {
        FfileReader ffileReader = null;
        MeasuramentCount meassuramentCount = new MeasuramentCount();
        SumMessurement sumMessurement = new SumMessurement();

        try {
            ffileReader = new FfileReader("src/main/resources/Day1SonarSweep/puzzleInput.txt");
            ffileReader.puzzleInputsToArryaList();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(meassuramentCount.count(ffileReader.getPuzzleInputs()));
        sumMessurement.count(ffileReader.getPuzzleInputs());
        sumMessurement.showSums();
        System.out.println(meassuramentCount.count(sumMessurement.getSum()));
    }
}
