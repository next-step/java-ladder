package domain;

import view.InputView;
import view.ResultView;

public class LadderGame {
    public static void main(String args[]) {
        LadderMember ladderMember = LadderMember.from(InputView.typeMemeber(), InputView.typeResult());
        int depth = InputView.typeDepth();
        Ladder ladder = Ladder.from(depth, ladderMember.totalMember());
        ResultView.printLadder(ladder, ladderMember.getMemberArr());
        ResultView.printResult(ladderMember.getResult());

        LadderGameResult ladderGameResult = new LadderGameResult(ladderMember ,ladder.trackingLadder(ladderMember.totalMember()));

        int repeat = 2;
        for(int i = 0; i < repeat; i++) {
            ResultView.printMemberResult(ladderGameResult.showMemberResult(InputView.typePersonResult()));
        }
    }
}
