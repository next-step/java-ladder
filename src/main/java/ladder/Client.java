package ladder;

import ladder.view.InputView;

import java.util.List;

public class Client {

    private static List<String> parsedInput;

    public static void main(String[] args) {
        userSetUpPhase();
    }

    private static void userSetUpPhase() {
        String rawInput = InputView.askNames();
        parsedInput = InputParser.parseRawInput(rawInput);
    }
}
