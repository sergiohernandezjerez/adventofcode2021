package day3BinaryDiagnostic;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProcessBinaryInputSecond {

    private ArrayList<String> puzzleInputs = new ArrayList<>();
    private ArrayList<String> puzzleInputs1 = new ArrayList<>();
    private BufferedReader br = null;
    private Integer zero = 0;
    private Integer one = 0;
    private Integer numberOfCharacters = 0;
    private StringBuilder gamma = new StringBuilder("");
    private StringBuilder epsilon = new StringBuilder("");


    public void puzzleInputsToArryaListString(BufferedReader br) throws IOException {
        String linea;
        try {
            while((linea = (br.readLine())) != null){
                puzzleInputs.add(linea);
                puzzleInputs1.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            br.close();
        }
    }

    public void createOxygenGeneratorRating(){
        Integer inputLenght = puzzleInputs.get(0).length();
            while(getNumberOfCharacters() < inputLenght) {
                setOne(0);
                setZero(0);
                for (String input : puzzleInputs) {
                    compareBits(getNumberOfCharacters(), input);
                }
                showColumnsInformation();

                constructRate(getZero(), getOne(), numberOfCharacters);
                sumI();
            }
        showResultInformation(puzzleInputs);
    }

    public void createCO2ScrubberRating(){
        Integer inputLenght = puzzleInputs1.get(0).length();
        resetNumberOfCharacters();
        while(getNumberOfCharacters() < inputLenght) {
            setOne(0);
            setZero(0);
            for (String input : puzzleInputs1) {
                compareBits(getNumberOfCharacters(), input);
            }
            showColumnsInformation();
            constructRateCO2(getZero(), getOne(), numberOfCharacters);
            sumI();
        }
        showResultInformation(puzzleInputs1);

    }

    private void showColumnsInformation() {
        System.out.println("Column: " + getNumberOfCharacters() + " Zero: " + getZero() + "-- One: " + getOne());
    }

    private void showResultInformation(ArrayList<String> inputsToShow) {
        System.out.println(inputsToShow);
        System.out.println("Result: " + (Integer.parseInt(String.valueOf(puzzleInputs.get(0)),2) * Integer.parseInt(String.valueOf(puzzleInputs1.get(0)),2)));

    }

    public void compareBits(Integer i, String input){
            if (input.charAt(i) == '0') {
                sumZero();
            } else {
                sumOne();
            }

    }

    public void regenerateInputs(String bitToSave, Integer position){
        ArrayList<String> newInputs = new ArrayList<>();
        for (String inputs:puzzleInputs) {
            if(String.valueOf(inputs.charAt(position)).equals(bitToSave)){
                newInputs.add(inputs);
            }
        }
        puzzleInputs.clear();
        puzzleInputs.addAll(newInputs);
    }

    public void regenerateInputs1(String bitToSave, Integer position){
        ArrayList<String> newInputs1 = new ArrayList<>();
        for (String inputs:puzzleInputs1) {
            if(String.valueOf(inputs.charAt(position)).equals(bitToSave)){
                newInputs1.add(inputs);
            }
        }
        puzzleInputs1.clear();
        puzzleInputs1.addAll(newInputs1);
    }

    public void showInputs(){
        for(String input:puzzleInputs){
            System.out.println(input);
        }
    }

    public void constructRate(Integer zero, Integer one, Integer position){
        if(puzzleInputs.size() > 1){
            if(zero > one){
                regenerateInputs("0", position);
            }else if(zero == one){
                regenerateInputs("1", position);
            }else{
                regenerateInputs("1", position);
            }
        }
    }

    public void constructRateCO2(Integer zero, Integer one, Integer position){
        if(puzzleInputs1.size() > 1){
            if(zero > one){
                regenerateInputs1("1", position);
            }else if(zero == one){
                regenerateInputs1("0", position);
            }else{
                regenerateInputs1("0", position);
            }
        }

    }

    public void addCharToString(StringBuilder rateString, String charBit){
        rateString.append(charBit);
    }

    public Integer getZero() {
        return zero;
    }

    public void setZero(Integer zero) {
        this.zero = zero;
    }

    public void sumZero(){
        this.zero++;
    }

    public void sumOne(){
        this.one++;
    }

    public void sumI(){
        this.numberOfCharacters++;
    }

    public Integer getOne() {
        return one;
    }

    public void setOne(Integer one) {
        this.one = one;
    }

    public Integer getNumberOfCharacters() {
        return numberOfCharacters;
    }

    public void resetNumberOfCharacters(){
        this.numberOfCharacters = 0;
    }

}
