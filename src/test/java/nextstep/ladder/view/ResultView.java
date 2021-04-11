package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Members;

public class ResultView {
    public static void print(Members members, Ladder ladder) {
        printMembers(members);
        printLadder(ladder);
    }

    private static void printMembers(Members members) {
        members.forEach(member -> System.out.printf("%6s", member));
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        ladder.lines().forEach(ResultView::printLine);
    }

    private static void printLine(Line line) {
        System.out.print("     |");
        line.points().forEach(point -> {
            if (point.value()) {
                System.out.print("-----|");
            }
            if (!point.value()) {
                System.out.print("     |");
            }
        });
        System.out.println();
    }
}
