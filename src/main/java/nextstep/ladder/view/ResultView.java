package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Direction;
import nextstep.ladder.domain.ladder.Ladder;

import java.util.List;

public class ResultView {

    private static final int ROW_INTERVAL = 5;

    public static void printNames(List<String> names) {
        System.out.println("사다리 결과");
        names.stream()
                .forEach(name -> {
                    System.out.printf(String.format("%-5s",name));
                });
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        for (int heightIndex = 0; heightIndex < ladder.getHeight(); heightIndex++) {
            searchRowLine(ladder, heightIndex);
            System.out.println();
        }
    }

    private static void searchRowLine(Ladder ladder, int heightIndex) {
        for (int lineIndex = 0; lineIndex < ladder.getLines().size(); lineIndex++) {
            System.out.print("|");
            isExistRowLine(ladder, heightIndex, lineIndex);
        }
    }

    private static void isExistRowLine(Ladder ladder, int heightIndex, int lineIndex) {
        if (ladder.getLines()
                .get(lineIndex)
                .getPointOfDirection(heightIndex)
                .equals(Direction.RIGHT)) {
            printRow();
            return;
        }
        printEmpty();
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
    }
}
