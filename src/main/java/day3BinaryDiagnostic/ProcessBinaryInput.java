package day3BinaryDiagnostic;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProcessBinaryInput {

    private ArrayList<String> puzzleInputs = new ArrayList<>();
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
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            br.close();
        }
    }

    public void createResult(){
        Integer inputLenght = puzzleInputs.get(0).length();
            while(getNumberOfCharacters() < inputLenght) {
                setOne(0);
                setZero(0);
                for (String input : puzzleInputs) {
                    compareBits(getNumberOfCharacters(), input);
                }
                showColumnsInformation();

                constructRate(getZero(), getOne());
                sumI();
            }
        showResultInformation();

    }

    private void showColumnsInformation() {
        System.out.println("Column: " + getNumberOfCharacters() + " Zero: " + getZero() + "-- One: " + getOne());
    }

    private void showResultInformation() {
        System.out.println("Gamma: " + gamma + " : " + Integer.parseInt(String.valueOf(gamma),2));
        System.out.println("Epsilon: " + epsilon + " : " + Integer.parseInt(String.valueOf(epsilon),2));
        System.out.println("Result: " + (Integer.parseInt(String.valueOf(gamma),2) * Integer.parseInt(String.valueOf(epsilon),2)));
    }

    public void compareBits(Integer i, String input){
            if (input.charAt(i) == '0') {
                sumZero();
            } else {
                sumOne();
            }

    }

    public void showInputs(){
        for(String input:puzzleInputs){
            System.out.println(input);
        }
    }

    public void constructRate(Integer zero, Integer one){
        if(zero > one){
            addCharToString(gamma, "0");
            addCharToString(epsilon, "1");
        }else{
            addCharToString(gamma, "1");
            addCharToString(epsilon, "0");
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

}
