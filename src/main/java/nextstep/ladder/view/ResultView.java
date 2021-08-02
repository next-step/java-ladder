package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Members;
import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.Prize;
import nextstep.ladder.domain.Prizes;
import nextstep.ladder.domain.Winners;

public class ResultView {
    public static final String VERTICAL_POINT = "     |";
    public static final String VERTICAL_AND_HORIZONTAL_POINT = "-----|";

    public static void print(Members members, Ladder ladder, Prizes prizes) {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();
        printMembers(members);
        printLadder(ladder);
        printPrizes(prizes);
        System.out.println();
    }

    public static void printResult(Prize prize) {
        System.out.println();
        System.out.println("실행결과");
        System.out.println(prize.value());
        System.out.println();
    }

    private static void printMembers(Members members) {
        members.names()
            .forEach(name -> System.out.printf("%6s", name));
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        ladder.stream()
            .forEach(ResultView::printLine);
    }

    private static void printLine(Line line) {
        System.out.print(VERTICAL_POINT);
        line.forEach(ResultView::printPoint);
        System.out.println();
    }

    private static void printPoint(Point point) {
        if (point.value()) {
            System.out.print(VERTICAL_AND_HORIZONTAL_POINT);
            return;
        }
        System.out.print(VERTICAL_POINT);
    }

    private static void printPrizes(Prizes prizes) {
        prizes.names().stream()
            .forEach(name -> System.out.printf("%6s", name));
        System.out.println();
    }

    public static void printResult(Winners winners) {
        System.out.println();
        System.out.println("실행결과");
        winners.stream()
            .forEach(winner -> System.out.println(winner.member().name + " : " + winner.prize().name));
        System.out.println();
    }
}
