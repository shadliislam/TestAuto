package supportClass;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Test {


    public static void main(String[] args) {


        Scanner reader = new Scanner(System.in);
        System.out.println("Put a value");
        int n = reader.nextInt();

        if (n%2!=0)
            System.out.println("weird");
        else if ((n%2)==0){
            if(2<n && n<5 )
                System.out.println("Not weird");
            else if (6<n && n<20)
                System.out.println("Weird");
            else  if( n>20)
                System.out.println("Not weird");
        }
    

    }

}
