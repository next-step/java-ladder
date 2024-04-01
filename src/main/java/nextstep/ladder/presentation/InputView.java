package nextstep.ladder.presentation;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public List<String> inputUserNames() {
        return List.of(SCANNER.nextLine().split(","));
    }

    public int inputLadderHeight() {
        return inputNumber();
    }

    private int inputNumber() {
        int input = SCANNER.nextInt();

        //엔터값 지우기
        SCANNER.nextLine();

        return input;
    }
}
