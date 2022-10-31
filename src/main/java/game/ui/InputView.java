package game.ui;

import game.util.SingletonScanner;

public final class InputView {

    private InputView() {
    }

    public static String inputString() {
        return SingletonScanner.getInstance().nextLine();
    }

    public static int inputInteger() {
        return Integer.parseInt(SingletonScanner.getInstance().nextLine());
    }
}