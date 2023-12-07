package nextstep.ladder.view;

import java.io.InputStream;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView(InputStream in) {
        this.scanner = new Scanner(in);
    }

    public static InputView from(InputStream in) {
        return new InputView(in);
    }

    public String initPlayers() {
        return scanner.nextLine();
    }

    public int initLadderHeight() {
        return scanner.nextInt();
    }

    public String initGameResult() {
        return scanner.next();
    }
}
