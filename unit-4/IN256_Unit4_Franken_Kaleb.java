
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

//*********************************************************

//****Assignment 5 Section 1

//*********************************************************


class IN256_Unit4_Franken_Kaleb {

    public static int FileLineCount(String fileName) throws IOException {
        int lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            while (reader.readLine() != null) {
                lines++;
            }
        }
        return lines;
    }
    public static void main(String[] args) throws IOException {
        ArrayList<String> produce = new ArrayList<>();
        produce.add("bananas 0.59");
        produce.add("grapes 2.99");
        produce.add("apples 1.49");
        produce.add("pears 1.39");
        produce.add("lettuce 0.99");
        produce.add("onions 0.79");
        produce.add("potatoes 0.59");
        produce.add("peaches 1.59");

        try (PrintWriter writer = new PrintWriter(new FileWriter("ProducePrice.txt"))) {
            for (String item : produce) {
                writer.println(item);
            }
        }

        int count = FileLineCount("ProducePrice.txt");
        System.out.println("There are " + count + " products in the file." );

        //*********************************************************

        //****Assignment 5 Section 2

        //*********************************************************

        produce.add("peppers 0.99");
        produce.add("celery 1.29");
        produce.add("cabbage 0.79");
        produce.add("tomatoes 1.19");
        
        try (PrintWriter writer = new PrintWriter(new FileWriter("ProducePrice.txt"))) {
            for (String item : produce) {
                writer.println(item);
            }
        }

        count = FileLineCount("ProducePrice.txt");
        System.out.println("There are " + count + " products in the file." );

        //*********************************************************

        //****Assignment 5 Section 3

        //*********************************************************

        ArrayList<String> producePrices = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("ProducePrice.txt"))) {
            String line;
            while ((line = reader.readLine())!= null){
                producePrices.add(line);
            }
        }
        
        System.out.println("Contents of Produce.txt");
        
        for (String item : producePrices){
            System.out.println(item);
        }
    }


}