package game.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ProcessingValues implements Serializable {

    private Random random = new Random();

    public synchronized String generateValue() {
        List<Integer> values = new ArrayList<>();
        while (values.size() != 4) {
            int a = random.nextInt(10);
            if (!values.contains(a)) {
                values.add(a);
            }
        }
        StringBuilder value = new StringBuilder();
        for (Integer v : values) {
            value.append(v);
        }
        return value.toString();
    }


    public synchronized BullsCows compareWithValue(String value, String mainValue) {
        if (value.equals(mainValue)) {
            return new BullsCows(4, 0);
        }
        int b = 0;
        int c = 0;
        char[] array = value.toCharArray();
        char[] generateArray = mainValue.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (mainValue.contains(String.valueOf(array[i]))) {
                c++;
            }
            if (array[i] == generateArray[i]) {
                b++;
            }
        }
        return new BullsCows(b, c - b);
    }

}
