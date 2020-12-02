package ladder;

import ladder.view.InputView;

import java.util.List;

public class Client {

    private static Users users;
    private static int ladderHeight;

    public static void main(String[] args) {
        userSetUpPhase();
        ladderHeightSetUpPhase();
    }

    private static void userSetUpPhase() {
        String rawInput = InputView.askNames();
        List<String> parsedInput = InputParser.parseRawInput(rawInput);
        users = new Users(parsedInput);
    }

    private static void ladderHeightSetUpPhase() {
        ladderHeight = InputView.askLadderHeight();
    }
}
