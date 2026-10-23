package Input;

import java.util.Scanner;

public class Reader {
    Scanner reader;

    public Reader(){
      reader = new Scanner(System.in);
    }

    public int readInt(){
        int numInt;
        while(!reader.hasNextInt()){
            reader.next();
            System.out.println("Вы ввели не число типа int!");
            System.out.print("Повторите ввод: ");
        }
        numInt = reader.nextInt();

        return numInt;
    }

    public double readDouble(){
        double numDouble;
        while(!reader.hasNextDouble()){
            reader.next();
            System.out.println("Вы ввели не число типа double!");
            System.out.print("Повторите ввод: ");
        }
        numDouble = reader.nextDouble();

        return numDouble;
    }

    public long readLong(){
        long numLong;
        while(!reader.hasNextLong()){
            reader.next();
            System.out.println("Вы ввели не число типа double!");
            System.out.print("Повторите ввод: ");
        }
        numLong = reader.nextLong();

        return numLong;
    }

    public String readLine(){
        String string = reader.nextLine().strip();
        return string;
    }
}