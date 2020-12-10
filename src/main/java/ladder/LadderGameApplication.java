package ladder;

import ladder.domain.LadderGame;
import ladder.domain.LadderGameResult;
import ladder.view.ConsoleView;
import ladder.view.UserInput;

public class LadderGameApplication {

    public static void main(String[] args) {

        UserInput input = new UserInput();
        String memberNames = input.readLadderMemberNames();
        String results = input.readLadderResults();
        int ladderHeight = input.readLadderHeight();

        LadderGame game = new LadderGame(memberNames,results, ladderHeight);
        LadderGameResult result = game.run();

        ConsoleView consoleView = new ConsoleView();
        consoleView.printResult(result);

        String member = input.readMemberNameForResult();
        consoleView.println("실행결과");
        if( "all".equals(member) ) {
            consoleView.printAllMemberResults(member, result.getAllLadderResult());
        } else {
            consoleView.printMemberResult(result.getLadderResult(member));
        }

    }
}
