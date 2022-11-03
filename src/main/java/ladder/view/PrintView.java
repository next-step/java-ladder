package ladder.view;

import java.util.Map.Entry;
import ladder.LadderResultDto;
import ladder.domain.Ladder;
import ladder.domain.Rewards;
import ladder.domain.line.Bar;
import ladder.domain.line.Line;

public class PrintView {

    private static final String STICK = "|";
    private static final String EMPTY_BAR = " ";
    private static final String SOLID_BAR = "-";

    public static void printLadder(Ladder ladder, Rewards rewards) {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println();

        for (String name : ladder.getNames()) {
            printName(ladder.getMaxNameLength(), name);
        }
        System.out.println();

        ladder.getLines()
                .forEach(line -> printLine(line, ladder.getMaxNameLength()));

        for (String reward : rewards.getRewards()) {
            printName(ladder.getMaxNameLength(), reward);
        }
        System.out.println();
        System.out.println();
    }

    public static void printResult(LadderResultDto resultDto) {
        if (resultDto.getResult().isEmpty()) {
            return;
        }

        if (resultDto.getResult().size() == 1) {
            printResultValue(resultDto);
            return;
        }

        printResultAll(resultDto);
    }

    private static void printResultAll(LadderResultDto resultDto) {
        System.out.println("실행 결과");
        for (Entry<String, String> entry : resultDto.getResult().entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println();
    }

    private static void printResultValue(LadderResultDto resultDto) {
        System.out.println("실행 결과");
        for (Entry<String, String> entry : resultDto.getResult().entrySet()) {
            System.out.println(entry.getValue());
        }
        System.out.println();
    }

    private static void printName(int maxNameLength, String name) {
        System.out.printf(EMPTY_BAR.repeat(maxNameLength - name.length() + 1) + name);
    }

    private static void printLine(Line line, int width) {
        for (Bar bar : line.getBars()) {
            System.out.print(getBar(bar.isAvailable(), width));
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
