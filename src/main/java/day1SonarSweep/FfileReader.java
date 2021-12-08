package day1SonarSweep;

import java.io.*;
import java.util.ArrayList;

public class FfileReader {
    private File fileToRead;
    private ArrayList<Integer> puzzleInputs = new ArrayList<>();
    private FileReader fr = null;
    private BufferedReader br = null;

    public FfileReader(String pathOfFileToRead) throws FileNotFoundException {
        this.fileToRead = new File(pathOfFileToRead);
        this.fr = new FileReader(fileToRead);
        this.br = new BufferedReader(fr);
    }

    public void puzzleInputsToArryaList() {
        String linea;
            try {
                while((linea = (br.readLine())) != null){
                    puzzleInputs.add(Integer.valueOf(linea));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                closeBuffers();
            }
    }

    public void processFileDay2() {
        String linea;
        Integer forward = 0;
        Integer down = 0;
        Integer up = 0;
        Integer aim = 0;
        Integer depth = 0;

        try {
            while((linea = (br.readLine())) != null){
                String[] forwardArray = linea.split(" ");
                if(linea.contains("forward")){
                    forward += Integer.valueOf(forwardArray[1]);
                    depth += aim  * Integer.valueOf(forwardArray[1]);
                }
                if(linea.contains("down")){
                    down += Integer.valueOf(forwardArray[1]);
                    aim += Integer.valueOf(forwardArray[1]);

                }
                if(linea.contains("up")){
                    up += Integer.valueOf(forwardArray[1]);
                    aim -= Integer.valueOf(forwardArray[1]);
                }
            }
            System.out.println((down-up)*forward);
            System.out.println("mutiply " + forward + " * " + depth + ": " + forward*depth);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            closeBuffers();
        }
    }

    public void closeBuffers(){
        try {
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showInputs(){
        for(Integer input:puzzleInputs){
            System.out.println(input);
        }
    }

    public BufferedReader getBr() {
        return br;
    }

    public ArrayList<Integer> getPuzzleInputs() {
        return puzzleInputs;
    }
}