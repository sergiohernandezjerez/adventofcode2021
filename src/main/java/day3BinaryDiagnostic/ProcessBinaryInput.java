package day3BinaryDiagnostic;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProcessBinaryInput {

    private ArrayList<String> puzzleInputs = new ArrayList<>();
    private BufferedReader br = null;


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
        Integer i = 0;
        StringBuilder gamma = new StringBuilder("");
        StringBuilder epsilon = new StringBuilder("");
            while(i < inputLenght) {
                Integer zero = 0;
                Integer one = 0;

                for (String input : puzzleInputs) {
                    if (input.charAt(i) == '0') {
                        zero++;
                    } else {
                        one++;
                    }
                }
                System.out.println("Column: " + i + " Zero: " + zero + "-- One: " + one);
                if(zero>one){
                    gamma.append("0");
                    epsilon.append("1");
                }else{
                    gamma.append("1");
                    epsilon.append("0");
                }
                i++;
            }
        System.out.println("Gamma: " + gamma + " : " + Integer.parseInt(String.valueOf(gamma),2));
        System.out.println("Epsilon: " + epsilon + " : " + Integer.parseInt(String.valueOf(epsilon),2));
        System.out.println("Result: " + (Integer.parseInt(String.valueOf(gamma),2) * Integer.parseInt(String.valueOf(epsilon),2)));

    }

    public void showInputs(){
        for(String input:puzzleInputs){
            System.out.println(input);
        }
    }
}
