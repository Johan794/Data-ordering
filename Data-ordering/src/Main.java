import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;




public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList <String> outputs = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size;
        int lines;
        String line;

        lines =Integer.parseInt(br.readLine());
        while (lines!=0){
            line = br.readLine();
            String[] input = line.split(" ");
            size = input.length;
            outputs.add(outPutSorted(input,size));
            lines--;
        }

        for (int i = 0; i <outputs.size() ; i++) {
            bw.write(outputs.get(i));
        }


        br.close();
        bw.close();


    }

    public static String outPutSorted(String[] input, int size){
        double temp;
        double finalAverage;
        double[] array = new double[size];
        String out;
        boolean changed = true;
        double count=0;

        int averageCount = array.length;

        for (int i = 0; i <size ; i++) {
            array[i]= Double.parseDouble(input[i]);
        }

        for(int i =1; i<array.length && changed; i++) {
            changed=false;
            for(int j=0; j<array.length-1; j++) {
                if(array[j]>array[j+1]) {
                    temp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    changed = true;
                    count+=1;

                }
            }

        }
        finalAverage = Math.floor(count/(averageCount-1)*100)/100;

        out=finalAverage+"-";

        for (int i = 0; i <averageCount-1 ; i++) {
           out+=array[i]+" ";
        }

        out+=array[averageCount-1 ]+"\n";
        return out;
    }

}
