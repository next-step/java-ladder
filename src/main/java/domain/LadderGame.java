package domain;

import view.InputView;
import view.ResultView;

public class LadderGame {
    public static void main(String args[]) {
        String memberArr[] = InputView.typeMemeber();
        String result[] = InputView.typeResult();
        int depth = InputView.typeDepth();
        Ladder ladder = Ladder.from(depth, memberArr.length);
        ResultView.printLadder(ladder, memberArr);
        ResultView.printResult(result);
        LadderGameResult ladderGameResult = new LadderGameResult(memberArr, ladder.followLadder());
        String memberName = InputView.typePersonResult();
        ResultView.printMemberResult(ladderGameResult.showMemberResult(memberName, result));
        String all = InputView.typePersonResult();
        ResultView.printAllResult(ladderGameResult.showMemberResult(all, result));
    }
}
