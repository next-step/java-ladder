package ladder.view;

import java.util.Arrays;
import java.util.Scanner;
import static ladder.view.InputViewConfig.*;
import static ladder.domain.LadderConfig.*;

public class InputView {

    private static final Scanner SCANNER;

    static {
        SCANNER = new Scanner(System.in);
    }

    private InputView() {}

    public static String inputUserName() {
        String names;
        do {
            System.out.print(INPUT_NAME_MESSAGE);
            names = SCANNER.next();
        } while (inputStringValidationCheck(names));
        return names;
    }

    public static int inputHeight() {
        int height;
        do {
            System.out.print(INPUT_LADDER_HEIGHT_MESSAGE);
            height = SCANNER.nextInt();
        } while (inputHeightValidationCheck(height));
        return height;
    }

    private static boolean inputHeightValidationCheck(int height) {
        if(height < MIN_HEIGHT) {
            System.out.print(INPUT_HEIGHT_ERROR);
            return true;
        }
        return false;
    }

    private static boolean inputStringValidationCheck(String input) {
        if(nameLengthCheck(input)) {
            System.out.print(INPUT_NAME_LENGTH_ERROR);
            return true;
        }
        return false;
    }

    private static boolean nameLengthCheck(String name) {
        int nameMaxLength = stringNameMaxLength(name);
        int nameMinLength = stringNameMinLength(name);
        return (nameMaxLength > MAX_NAME_LENGTH || nameMinLength < MIN_NAME_LENGTH);
    }

    private static int stringNameMaxLength(String input) {
        String[] strings = input.split(INPUT_NAME_SEPARATOR);
        return Arrays.stream(strings)
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }

    private static int stringNameMinLength(String input) {
        String[] strings = input.split(INPUT_NAME_SEPARATOR);
        return Arrays.stream(strings)
                .mapToInt(String::length)
                .min()
                .orElse(0);
    }
}
