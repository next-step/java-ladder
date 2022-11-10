package ladder.view;


import java.util.Scanner;


public class InputView {

    private InputView() {
    }

    private static final String COMMA = ",";

    private static final Scanner scanner = new Scanner(System.in);

    public static String[] getNames() {
        return scanner.next().split(COMMA);
    }

    public static int getHeight() {
        return scanner.nextInt();
    }
}
