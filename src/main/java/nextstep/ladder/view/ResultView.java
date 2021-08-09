package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Ladder;

import java.util.List;

public class ResultView {

    private static final int ROW_INTERVAL = 5;

    public static void printNames(List<String> names) {
        System.out.println("실행결과");
        names.stream()
                .forEach(name -> {
                    System.out.printf(String.format("%-5s",name));
                });
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        for (int heightIndex = 0; heightIndex < ladder.getHeight(); heightIndex++) {
            searchRowLine(ladder, heightIndex);
            System.out.printf("|");
            System.out.println();
        }
    }

    private static void searchRowLine(Ladder ladder, int heightIndex) {
        for (int lineIndex = 0; lineIndex < ladder.getLines().size()-1; lineIndex++) {
            System.out.printf("|");
            isExistRowLine(ladder, heightIndex, lineIndex);
        }
    }

    private static void isExistRowLine(Ladder ladder, int heightIndex, int lineIndex) {
        if (ladder.getLines().get(lineIndex).getPoints().get(heightIndex) && ladder.getLines().get(lineIndex+1).getPoints().get(heightIndex)) {
            printRow();
            ladder.getLines().get(lineIndex+1).setDrownPosition(heightIndex);
            return;
        }
        printEmpty();
    }

    private static void printEmpty() {
        for (int i = 0; i < ROW_INTERVAL; i++) {
            System.out.printf(" ");
        }
    }

    private static void printRow() {
        for (int i = 0; i < ROW_INTERVAL; i++) {
            System.out.printf("-");
        }
    }
}
