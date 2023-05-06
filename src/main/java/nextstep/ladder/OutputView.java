package nextstep.ladder;

import java.util.List;

public class OutputView {

    public static void printLadder(List<PersonName> personNames, Ladder ladder) {
        for (PersonName personName : personNames) {
            System.out.printf("%6s", personName.getName());
        }
        System.out.println();
        for (Line line : ladder.getLines()) {
            System.out.print("     |");
            for (Boolean point : line.getPoints()) {
                if (point) {
                    System.out.print("-----|");
                } else {
                    System.out.print("     |");
                }
            }
            System.out.println();
        }
    }
}
