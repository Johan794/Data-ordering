import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
//Revisar la rubrica

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input[];
        String line = br.readLine();
        int size =0;

        input = line.split("");
        size = input.length;


        bw.write(outPutSorted(input,size));


        br.close();
        bw.close();

    }

    public static String outPutSorted(String input[] ,int size){
        double temp;
        double[] array = new double[size];
        String out="";
        boolean changed = true;
        int count=0;
        ArrayList<Integer> average = new ArrayList<Integer>();

        int averageCount=0;

        for (int i = 0; i <size ; i++) {
            array[i]= Double.parseDouble(input[i]);
        }

        for(int i =1; i<array.length && changed; i++) {
            changed=false;
            count=0;
            for(int j=0; j<array.length-1; j++) {
                if(array[j]>array[j+1]) {
                    temp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    changed = true;
                    count+=1;
                }else {
                    count=0;
                }

            }
            average.add(count);

        }
        for (int i = 0; i <average.size() ; i++) {
            averageCount+=average.get(i);
        }
        out+=averageCount/average.size()+"-";


        return out;
    }

}
