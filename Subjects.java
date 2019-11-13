import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Subjects{

    public static void main( String[] args ){
        int eng = 0, math = 0, science = 0;
        String stream = "";
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);

        System.out.println("Enter three inputs for marks obtained in : English, Math and Science\n");

        try {
            eng = Integer.parseInt(br.readLine());
        }
        catch (IOException e) {
            System.out.println("Error in parsing "+ e);
        }
        catch( NumberFormatException e) {
            System.out.println("Error in parsing "+ e);
        }

        try {
            math = Integer.parseInt(br.readLine());
        }
        catch (IOException e) {
            System.out.println("Error in parsing "+ e);
        }
        catch( NumberFormatException e) {
            System.out.println("Error in parsing "+ e);
        }

        try {
            science = Integer.parseInt(br.readLine());
        }
        catch (IOException e) {
            System.out.println("Error in parsing "+ e);
        }
        catch( NumberFormatException e) {
            System.out.println("Error in parsing "+ e);
        }

        if (eng >= 80 && math >= 80 && science >= 80) {
            stream = "Pure Science";
        }
        else if ( math >= 80 && science >= 80) {
            stream = "Biology Science";
        }
        else if ( eng >= 80 && math >= 80) {
            stream = "Commerce";
        }
        else{
            stream = "Undefined";
        }

        System.out.print("Marks obtained in English = "+eng+
                         "\n Marks obtained in Math = "+math+
                         "\n Marks obtaiend in Science = "+science+
                         "\n Stream alloted for the candidate = "+stream+"\n");
    }

}