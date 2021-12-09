package day3BinaryDiagnostic;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProcessBinaryInputSecond {

    private ArrayList<String> oxigenGeneratorRating = new ArrayList<>();
    private ArrayList<String> CO2ScrubberRating = new ArrayList<>();
    private BufferedReader br = null;
    private Integer zero = 0;
    private Integer one = 0;
    private Integer numberOfCharacters = 0;


    public void puzzleInputsToArryaListString(BufferedReader br) throws IOException {
        String linea;
        try {
            while((linea = (br.readLine())) != null){
                oxigenGeneratorRating.add(linea);
                CO2ScrubberRating.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            br.close();
        }
    }

    public void createRating(ArrayList<String> inputs, String ratingMode){
        Integer inputLenght = inputs.get(0).length();

        resetNumberOfCharacters();

            while(getNumberOfCharacters() < inputLenght) {
                setOne(0);
                setZero(0);
                for (String input : inputs) {
                    compareBits(getNumberOfCharacters(), input);
                }

                constructRate(getZero(), getOne(), numberOfCharacters, inputs, ratingMode);
                sumI();
            }
    }

    public void showResultInformation() {
        Integer oxigenRating = Integer.parseInt(String.valueOf(oxigenGeneratorRating.get(0)),2);
        Integer co2Rating = Integer.parseInt(String.valueOf(CO2ScrubberRating.get(0)),2);

        System.out.println("Result: " + oxigenRating * co2Rating);

    }

    public void compareBits(Integer i, String input){
            if (input.charAt(i) == '0') {
                sumZero();
            } else {
                sumOne();
            }
    }

    public void regenerateInputs(String bitToSave, Integer position, ArrayList<String> inputsArray){
        ArrayList<String> newInputs = new ArrayList<>();
        for (String inputs: inputsArray) {
            if(String.valueOf(inputs.charAt(position)).equals(bitToSave)){
                newInputs.add(inputs);
            }
        }
        inputsArray.clear();
        inputsArray.addAll(newInputs);
    }

    public void constructRate(Integer zero, Integer one, Integer position, ArrayList<String> inputs, String ratingMode){
        if(inputs.size() > 1){
            switch (ratingMode){
                case "oxygen":
                    constructRateOxigen(zero, one, position, inputs);
                    break;
                case "co2":
                    constructRateCO2(zero, one, position, inputs);
                    break;
            }
        }
    }

    public void constructRateOxigen(Integer zero, Integer one, Integer position, ArrayList<String> inputs){
        if(zero > one){
            regenerateInputs("0", position,inputs);
        }else if(zero == one){
            regenerateInputs("1", position, inputs);
        }else{
            regenerateInputs("1", position, inputs);
        }
    }

    public void constructRateCO2(Integer zero, Integer one, Integer position, ArrayList<String> inputs){
            if(zero > one){
                regenerateInputs("1", position, inputs);
            }else if(zero == one){
                regenerateInputs("0", position, inputs);
            }else{
                regenerateInputs("0", position, inputs);
            }
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

    public ArrayList<String> getOxigenGeneratorRating() {
        return oxigenGeneratorRating;
    }

    public ArrayList<String> getCO2ScrubberRating() {
        return CO2ScrubberRating;
    }
}
