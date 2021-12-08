package day1SonarSweep;

import java.util.ArrayList;

public class MeasuramentCount {
    private Integer total = 0;
    private Integer anterior = 0;

    public Integer count(ArrayList<Integer> measuramentInputs){

        for (Integer inputs : measuramentInputs) {
            if(anterior < inputs && anterior > 0){
                showInputs(true, inputs);
                total++;
                anterior = inputs;
            }else{
                showInputs(false, inputs);
                anterior = inputs;
            }
        }
        return total;
    }

    public void showInputs(boolean action, Integer inputs){
        if (action){
            System.out.print(anterior + " inferior\n" + inputs + " superior\n-------" + "\nSuma\n-------\n");
        }else{
            System.out.print(anterior + " superior\n" + inputs + " inferior\n-------" + "\nNo Suma\n#############################\n");
        }

    }
}
