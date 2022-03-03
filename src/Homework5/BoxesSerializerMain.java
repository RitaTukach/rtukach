package Homework5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BoxesSerializerMain {

        public static final Random RANDOM = new Random(100);

        public static void main(String[] args) throws IOException {

            List<Box> boxList = new ArrayList<>(5);

            while (boxList.size() < 5) {
                boxList.add(createBox());
            }

            serializeListOfObjects(boxList, "D:\\saveBoxes.ser");
        }

        private static Box createBox() {
            return new Box(RANDOM.nextInt(), RANDOM.nextInt(), RANDOM.nextInt());
        }

        private static void serializeListOfObjects(List<?> boxList, String fileName) {
            try (ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(fileName))) {
                for (Object o : boxList) {
                    oos.writeObject(o);
                }
            } catch (IOException e) {
                System.err.println(e.getMessage() + Arrays.toString(e.getStackTrace()));
            }
        }
    }
