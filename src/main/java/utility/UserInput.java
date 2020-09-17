package utility;

import java.util.Scanner;

import static view.View.*;

public class UserInput {
    public static Scanner SC = new Scanner(System.in);

    private UserInput() {
    }

    public static String inputUserNamse() {
        System.out.println(NAMES);
        String input = SC.nextLine();
        return input;
    }

    public static int inputHeight() {
        System.out.println(HEIGHT);
        int height = SC.nextInt();
        SC.nextLine();

        System.out.println(RESULT);
        return height;
    }
}
