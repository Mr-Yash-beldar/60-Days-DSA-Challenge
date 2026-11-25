import java.util.ArrayList;

public class ArrayList2 {

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(49);

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > max) {
                max = numbers.get(i);
            }
        }
        System.out.println("Maximum number: " + max);

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
                i--; // Adjust the index after removal
            }
            System.out.println("Numbers: " + numbers);
        }

    }

}
