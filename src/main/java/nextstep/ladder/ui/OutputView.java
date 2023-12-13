package nextstep.ladder.ui;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Member;

import java.util.List;

public class OutputView {

    public static void outputMembers(List<Member> members) {
        members.forEach(member -> System.out.printf("%6s", member.getName()));
        System.out.println();
    }

    public static void outputLadder(LadderGame ladderGame) {
        List<Member> members = ladderGame.getMembers();
        Ladder ladder = ladderGame.getLadder();

        outputMembers(members);

        int height = ladder.getHeight();
        List<Line> lines = ladder.getLines();

        for (int i = 0; i < height; i++) {
            System.out.printf("%5s", "");
            for (int j = 0; j < members.size() - 1; j++) {
                if (lines.get(i).getPoints().get(j)) {
                    System.out.print("|-----");
                    continue;
                }
                System.out.printf("%-6s", "|");
            }
            System.out.printf("%-6s", "|");
            System.out.println();
        }
    }
}
