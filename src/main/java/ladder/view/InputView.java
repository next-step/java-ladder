package ladder.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    public static String PERSON_NAME_SEPARATOR = ",";

    public static String[] personNameInput() {
        return splitPersonName(scanner.nextLine());
    }

    public static String[] splitPersonName(String text) {
        return text.split(PERSON_NAME_SEPARATOR);
    }
}
