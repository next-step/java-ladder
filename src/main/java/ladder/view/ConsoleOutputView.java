package ladder.view;

import ladder.domain.LadderGame;
import ladder.domain.ladder.Ladder;
import ladder.domain.member.MemberGroup;

public class ConsoleOutputView {
    private ConsoleOutputView() {
    }

    public static void printLadderGame(LadderGame ladderGame) {
        printMemberGroup(ladderGame.getMemberGroup());
        printLadder(ladderGame.getLadder());
    }

    private static void printMemberGroup(MemberGroup memberGroup) {
        System.out.println(memberGroup);
    }

    private static void printLadder(Ladder ladder) {
        System.out.println(ladder);
    }
}
