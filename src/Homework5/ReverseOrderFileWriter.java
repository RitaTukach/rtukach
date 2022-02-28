package Homework5;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseOrderFileWriter {

    public static void main(String[] args) throws IOException {

        File inputFileName = new File("D://INPUT.txt");
        File outputFileName = new File("D://OUTPUT.txt");
        List<String> list = new ArrayList<>();

        try (FileReader fr = new FileReader(inputFileName))
        {
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();

            while (line != null) {
                list.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            try (FileWriter writer = new FileWriter(outputFileName))
            {
                Collections.reverse(list);
                for (String i : list) {
                    writer.write(i);
                    writer.append("\n");
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
    }
}
