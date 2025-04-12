package nextstep.ladder.view;

import nextstep.ladder.domain.LadderLine;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Results;

import java.util.List;
import java.util.Scanner;

public class ConsoleOutputView implements OutputViewInterface {
    private static final Scanner scanner = new Scanner(System.in);
    public static final String SHOW_RESULT_NAME_PROMPT = "결과를 보고 싶은 사람은?(all:전부, exit:종료)";
    public static final String PLAY_RESULT = "실행 결과";

    @Override
    public void printLadder(List<Name> names, List<LadderLine> ladder, List<Name> results) {
        System.out.println("사다리 결과");
        names.forEach(name -> System.out.print(padLeft(name.toString(), 6)));
        System.out.println();

        ladder.forEach(ladderLine -> {
            System.out.print("     |");
            ladderLine.getBridgeStatus().forEach(bridge -> {
                System.out.print(bridge.toString() + "|");
            });
            System.out.println();
        });
        results.forEach(result -> System.out.print(padLeft(result.toString(), 6)));
        System.out.println();
    }

    // 한글은 2칸, 나머지는 1칸으로 계산
    public int getDisplayWidth(String str) {
        int width = 0;
        for (char ch : str.toCharArray()) {
            width += (isFullWidth(ch) ? 2 : 1);
        }
        return width;
    }

    public boolean isFullWidth(char ch) {
        return Character.UnicodeBlock.of(ch) == Character.UnicodeBlock.HANGUL_SYLLABLES
                || Character.UnicodeBlock.of(ch) == Character.UnicodeBlock.HANGUL_JAMO
                || Character.UnicodeBlock.of(ch) == Character.UnicodeBlock.HANGUL_COMPATIBILITY_JAMO;
    }

    public String padLeft(String str, int totalWidth) {
        int padding = totalWidth - getDisplayWidth(str);
        return " ".repeat(Math.max(0, padding)) + str;
    }

    @Override
    public void printGameResult(List<Name> names, Results matchResults) {
        String input = getStringInput(SHOW_RESULT_NAME_PROMPT);
        if (input.equalsIgnoreCase("exit")) {
            return;
        }

        System.out.println(PLAY_RESULT);

        if (input.equals("all")) {
            printAllMatchResult(names, matchResults);
            printGameResult(names, matchResults);
            return;
        }

        System.out.println(matchResults.getResult(input));
        printGameResult(names, matchResults);
    }

    private static void printAllMatchResult(List<Name> names, Results matchResults) {
        names.forEach(name -> {
            System.out.println(name + " : " + matchResults.getResult(name));
        });
    }

    public String getStringInput(String prompt) {
        System.out.println(prompt);
        String input = scanner.nextLine().trim();
        return input.trim();
    }
}
