package day3BinaryDiagnostic;

import day1SonarSweep.FfileReader;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Day3 {

    public static void main(String[] args) {
        FfileReader ffileReader = null;
        ProcessBinaryInput processBinaryInput = new ProcessBinaryInput();
        ProcessBinaryInputSecond processBinaryInputSecond = new ProcessBinaryInputSecond();

        try {
            ffileReader = new FfileReader("src/main/resources/Day3BinaryDiagnostic/puzzleInput.txt");
            try {
                processBinaryInputSecond.puzzleInputsToArryaListString(ffileReader.getBr());
            } catch (IOException e) {
                e.printStackTrace();
            }
            //processBinaryInput.showInputs();
            //processBinaryInput.createResult();
            processBinaryInputSecond.createRating(processBinaryInputSecond.getOxigenGeneratorRating(), "oxygen");
            processBinaryInputSecond.createRating(processBinaryInputSecond.getCO2ScrubberRating(), "co2");
            processBinaryInputSecond.showResultInformation();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}