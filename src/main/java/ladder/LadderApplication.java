package ladder;

public class LadderApplication {

    public static void main(String[] args) {
        UserNames userNames = InputView.inputUserName();
        Awards awards = InputView.inputGameAwards();
        int ladderHeight = InputView.inputLadderHeight();

        LadderGenerator ladderGenerator = new LadderGenerator(new RowGenerator());
        Ladder ladder = ladderGenerator.create(userNames.size(), ladderHeight);

        ResultView.printResult(userNames, ladder, ladder.play(userNames.size()), awards);
    }
}
