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

        LadderMember ladderMember = LadderMember.from(memberArr, result);
        LadderGameResult ladderGameResult = new LadderGameResult(ladderMember ,ladder.trackingLadder(memberArr.length));

        int repeat = 2;
        for(int i = 0; i < repeat; i++) {
            ResultView.printMemberResult(ladderGameResult.showMemberResult(InputView.typePersonResult()));
        }
    }
}
