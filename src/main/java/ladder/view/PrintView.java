package ladder.view;

import ladder.Ladder;
import ladder.Rewards;
import ladder.line.Line;

public class PrintView {

    private static final String STICK = "|";
    private static final String EMPTY_BAR = " ";
    private static final String SOLID_BAR = "-";

    public static void printLadder(Ladder ladder, Rewards rewards) {
        for (String name : ladder.getNames()) {
            printName(ladder.getMaxNameLength(), name);
        }
        System.out.println();

        ladder.getLines()
                .forEach(line -> printLine(line, ladder.getMaxNameLength()));

        for (String reward : rewards.getRewards()) {
            printName(ladder.getMaxNameLength(), reward);
        }
    }

    private static void printName(int maxNameLength, String name) {
        System.out.printf(EMPTY_BAR.repeat(maxNameLength - name.length() + 1) + name);
    }

    private static void printLine(Line line, int width) {
        for (Boolean bar : line.getBars()) {
            System.out.print(getBar(bar, width));
        }
        System.out.println();
    }

    private static String getBar(Boolean bar, int width) {
        if (bar) {
            return SOLID_BAR.repeat(width) + STICK;
        }
        return EMPTY_BAR.repeat(width) + STICK;
    }

    public static void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printTryAgain() {
        System.out.println("입력값을 확인하고 다시 압력해주세요.");
    }
}
