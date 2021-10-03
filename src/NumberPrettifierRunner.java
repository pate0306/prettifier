import java.util.Scanner;

public class NumberPrettifierRunner {
    public static void main(String[] args) {
        float number = 0;
        Scanner scanner = new Scanner(System.in);
        NumberPrettifier numberPrettifier = new NumberPrettifierImpl();

        System.out.print("Enter a number to prettify: ");
        number = scanner.nextFloat();
        System.out.println(numberPrettifier.prettify(number));
    }
}
