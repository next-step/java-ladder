package ladder.view;

import java.io.InputStream;
import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public InputView() {
        this(System.in);
    }

    public InputView(final InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public String inputPlayerName() {
        return scanner.nextLine();
    }
}
