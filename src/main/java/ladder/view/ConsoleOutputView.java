package ladder.view;

import ladder.domain.LadderGame;
import ladder.domain.ladder.Ladder;
import ladder.domain.member.MemberGroup;

public class ConsoleOutputView {
    private ConsoleOutputView() {
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printLadderGame(LadderGame ladderGame) {
        System.out.println("실행결과");
        printEmptyLine();

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
