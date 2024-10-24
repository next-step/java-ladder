package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static String[] inputPlayers() {
        Scanner scanner = new Scanner(System.in);
        return scanner.useDelimiter(",").nextLine().split(",");
    }

    public static int inputHeight() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
