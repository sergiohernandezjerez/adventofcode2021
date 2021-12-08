package day1SonarSweep;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SumMessurement {

    private Integer total = 0;
    private Integer anterior = 0;
    private ArrayList<Integer> sum =  new ArrayList<>();

    public void count(ArrayList<Integer> measuramentInputs){
        for (int i = 0; i < measuramentInputs.size();i++) {
            if(i<measuramentInputs.size() - 2){
                sum.add(measuramentInputs.get(i) +  measuramentInputs.get(i+1) + measuramentInputs.get(i+2));
            }
        }
    }

    public void showSums(){
        for (Integer sum : sum) {
            System.out.println(sum);
        }
    }

    public ArrayList<Integer> getSum() {
        return sum;
    }
}
