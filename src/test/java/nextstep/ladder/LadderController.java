package nextstep.ladder;

public class LadderController {
    private static InputView inputView = InputView.getInputView();
    private static ResultView resultView = ResultView.getResultView();

    public static void main(String[] args) {
        Users users = inputView.enterUserNames();
        int ladderHeight = inputView.enterLadderHeight();
        int countOfPerson = users.getUsers().size();
        Ladder ladder = new Ladder(countOfPerson, ladderHeight);

        resultView.printLadder(users, ladder);

    }
}
