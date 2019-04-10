package ladder.view;

import ladder.domain.LadderGame;
import ladder.domain.ladder.Ladder;
import ladder.domain.member.Member;
import ladder.domain.member.MemberGroup;
import ladder.domain.reward.Rewards;

public class ConsoleOutputView {
    private static final String ALL = "all";
    private ConsoleOutputView() {
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printLadderGame(LadderGame ladderGame) {
        printMemberGroup(ladderGame.getMemberGroup());
        printLadder(ladderGame.getLadder());
        printRewards(ladderGame.getRewards());
    }

    private static void printMemberGroup(MemberGroup memberGroup) {
        System.out.println(memberGroup);
    }

    private static void printLadder(Ladder ladder) {
        System.out.println(ladder);
    }

    private static void printRewards(Rewards rewards) {
        System.out.println(rewards);
    }

    public static void printLadderGameResult(LadderGame ladderGame, Member target) {
        System.out.println("실행 결과");

        if (ALL.equals(target.getName())) {
            System.out.println(ladderGame.getAllResult());
            return;
        }

        System.out.println(ladderGame.getResult(target));
    }
}
