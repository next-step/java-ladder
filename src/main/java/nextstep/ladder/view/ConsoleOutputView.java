package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.Map;
import java.util.Scanner;

public class ConsoleOutputView implements OutputViewInterface {
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void printPrompt(String prompt) {
        System.out.println(prompt);
    }

    @Override
    public void printLadder(Participants participants, Ladder ladder, Rewards rewards) {
        System.out.println("사다리 결과");
        participants.asList()
                .forEach(name -> System.out.print(padLeft(name.toString(), 6)));
        System.out.println();

        ladder.asList()
                .forEach(ladderLine -> {
                    System.out.print("     ");
                    ladderLine.asList().forEach(this::printBridge);
                    System.out.println();
                });
        rewards.asList()
                .forEach(result -> System.out.print(padLeft(result.toString(), 6)));
        System.out.println();
    }

    private void printBridge(Bridge bridge) {
        if (bridge.nextDirection() == Direction.RIGHT) {
            System.out.print("|-----");
            return;
        }
        System.out.print("|     ");
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
    public void printAllMatchResult(Map<Name, Name> matched) {
        matched.forEach((participant, reward) -> {
            System.out.println(participant + " : " + reward);
        });
    }

    @Override
    public void printResult(Name reward) {
        System.out.println(reward);
    }
}
