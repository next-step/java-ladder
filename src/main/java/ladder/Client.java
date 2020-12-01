package ladder;

import ladder.view.InputView;

import java.util.List;

public class Client {

    private static Users users;

    public static void main(String[] args) {
        userSetUpPhase();
    }

    private static void userSetUpPhase() {
        String rawInput = InputView.askNames();
        List<String> parsedInput = InputParser.parseRawInput(rawInput);
        users = new Users(parsedInput);
    }
}
