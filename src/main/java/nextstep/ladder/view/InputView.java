package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static String inputNames() {
        return sc.nextLine();
    }

    public static int inputLadderHeight() {
        return Integer.parseInt(sc.nextLine());
    }
}
