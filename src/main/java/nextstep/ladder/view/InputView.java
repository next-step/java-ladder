package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputNames() {
        ResultView.printInputName();
        return scanner.nextLine();
    }

    public static int inputLadderHeight() {
        ResultView.printInputHeight();
        return scanner.nextInt();
    }
}
