package ladder;

public class LadderApplication {

    public static void main(String[] args) {
        UserNames userNames = InputView.inputUserName();
        Awards awards = InputView.inputGameAwards();
        int ladderHeight = InputView.inputLadderHeight();

        Ladder ladder = Ladder.of(userNames.size(), ladderHeight);

        System.out.println(ladder.play(userNames.size()));

        ResultView.printResult(userNames, ladder, ladder.play(userNames.size()), awards);
    }
}
