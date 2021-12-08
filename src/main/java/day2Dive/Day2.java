package day2Dive;

import day1SonarSweep.FfileReader;

import java.io.FileNotFoundException;

public class Day2 {

    public static void main(String[] args) {
        FfileReader ffileReader = null;

        try {
            ffileReader = new FfileReader("src/main/resources/Day2Dive/puzzleInput");
            ffileReader.processFileDay2();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
