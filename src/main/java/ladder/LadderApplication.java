package ladder;

public class LadderApplication {

    public static void main(String[] args) {
        UserNames userNames = InputView.inputUserName();
        int ladderHeight = InputView.inputLadderHeight();

        Ladder ladder = Ladder.of(userNames.size(), ladderHeight);

        ResultView.printResult(userNames, ladder);
    }
}
