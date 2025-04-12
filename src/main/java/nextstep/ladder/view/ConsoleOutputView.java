package nextstep.ladder.view;

import nextstep.ladder.domain.LadderLine;
import nextstep.ladder.domain.Name;

import java.util.List;
import java.util.Map;

public class ConsoleOutputView implements OutputViewInterface {
    @Override
    public void printLadder(List<Name> names, List<LadderLine> ladder, List<Name> results) {
        names.forEach(name -> System.out.print(padLeft(name.toString(), 6)));
        System.out.println();

        ladder.forEach(ladderLine -> {
            System.out.print("     |");
            ladderLine.getBridgeStatus().forEach(bridge -> {
                System.out.print(bridge.toString() + "|");
//                if (bridge.isConnected()) {
//                    System.out.print("-----|");
//                    return;
//                }
//                System.out.print("     |");
            });
            System.out.println();
        });
        results.forEach(result -> System.out.print(padLeft(result.toString(), 6)));
        System.out.println();
    }

    @Override
    public void printResult(Map<Name, Name> result) {
        result.forEach((key, value) -> {
            System.out.println(key.toString() + " : " + value.toString());
        });
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
}
