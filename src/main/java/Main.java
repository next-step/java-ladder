import ladder.Ladder;
import ladder.LadderPlayerNames;
import view.InputView;
import view.ResultView;

public class Main {
    public static void main(String[] args) {
        String playerNamesString = InputView.getJoinMembersString();
        int maxLadderHeight = InputView.getMaxLadderHeight();

        LadderPlayerNames ladderPlayerNames = LadderPlayerNames.of(playerNamesString);
        int countOfPerson = ladderPlayerNames.size();
        int countOfColumn = countOfPerson - 1;
        Ladder ladder = Ladder.of(countOfColumn, maxLadderHeight);

        ResultView.printLunchResult(ladderPlayerNames, ladder);
    }
}
