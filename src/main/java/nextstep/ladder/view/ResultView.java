package nextstep.ladder.view;

import nextstep.ladder.domain.HorizontalLine;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.User;

import java.util.List;

public class ResultView {
    public static void printResult(Ladder ladder, List<User> users) {
        System.out.println("실행결과");
        users.forEach(user -> System.out.printf("%-6s", user.getName()));
        System.out.println();
        printLadder(ladder);
    }

    private static void printLadder(Ladder ladder) {
        for (int index = 0; index < ladder.size(); index++) {
            System.out.print("|");
            HorizontalLine horizontalLine = ladder.getByIndex(index);
            printHorizontalLine(horizontalLine);
            System.out.println();
        }
    }

    private static void printHorizontalLine(HorizontalLine horizontalLine) {
        for (int i = 0; i < horizontalLine.size(); i++) {
            Boolean hasLineOnIndex = horizontalLine.hasLineOnIndex(i);
            printHorizontalLineOrBlank(hasLineOnIndex);
            System.out.print("|");
        }
    }

    private static void printHorizontalLineOrBlank(boolean hasLine) {
        if (hasLine) {
            System.out.print("-----");
            return;
        }
        System.out.print("     ");
    }
}
