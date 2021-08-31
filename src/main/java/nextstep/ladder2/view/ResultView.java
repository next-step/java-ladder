package nextstep.ladder2.view;

import nextstep.ladder2.domain.Ladder;
import nextstep.ladder2.domain.LadderLine;
import nextstep.ladder2.domain.Point;

import java.util.List;

public class ResultView {

    private static final int ROW_INTERVAL = 5;

    public static void printNames(List<String> names) {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println();
        names.stream()
                .forEach(name -> {
                    System.out.printf(String.format("%-5s",name));
                });
        System.out.println();
    }


    public static void printLadder(Ladder ladder) {
        for (int i = 0; i < ladder.getHeightValue(); i++) {
            printLadderLine(ladder.getLadderLine(i));
            System.out.println();
        }
    }

    private static void printLadderLine(LadderLine ladderLine) {
        for (int i = 0; i < ladderLine.getPointSize(); i++) {
            System.out.print("|");
            printRowLine(ladderLine.getPoint(i));
        }
    }

    private static void printRowLine(Point point) {
        if (point.isRight()) {
            printRow();
        }
        if (!point.isRight()) {
            printEmpty();
        }
    }

    private static void printEmpty() {
        for (int i = 0; i < ROW_INTERVAL; i++) {
            System.out.print(" ");
        }
    }

    private static void printRow() {
        for (int i = 0; i < ROW_INTERVAL; i++) {
            System.out.print("-");
        }
    }

    public static void printResults(List<String> results) {
        results.stream()
                .forEach(result -> {
                    System.out.printf(String.format("%-5s",result));
                });
        System.out.println();
        System.out.println();
    }


    public static void printResult(String result) {
        System.out.println("실행결과");
        System.out.println(result);
        System.out.println();
    }

    public static void printAllResult(List<String> results, List<String> names, Ladder ladder) {
        System.out.println("실행결과");
        for (int i = 0; i < names.size(); i++) {
            System.out.print(names.get(i) + " : ");
            System.out.println(results.get(ladder.move(i)));
        }
    }
}
