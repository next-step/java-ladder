package nextstep.view;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import nextstep.domain.Ladder;
import nextstep.domain.Line;
import nextstep.domain.Name;
import nextstep.domain.Names;

/**
 * 출력 클래스
 */
public class OutputView {
    private static final char V = '|';
    private static final char H = '-';
    private static final int WIDTH = 5;

    /** 결과 */
    public void printResult(Names names, Ladder ladder) {
        System.out.println("실행 결과");

        // 1) 이름 줄
        System.out.println(formatNameLine(names));

        // 2) 사다리 줄
        ladder.lines().forEach(line ->
            System.out.println(formatLadderLine(line))
        );

        // 3) 보너스
        System.out.println(formatNameLine(bonus, width));

        // 5) 전체 결과
        System.out.println(printPersonalResult(names, ladder, bonus));
    }

    // TODO 분기처리
    public void printResult(String input) {

    }

    public String printPersonalResult(List<String> names, Ladder ladder, List<String> bonus) {
        StringBuilder builder = new StringBuilder();
        System.out.println("실행 결과");
        Map<Integer, Integer> result = ladder.result();

        IntStream.range(0, names.size())
            .forEach(i -> builder.append(names.get(i)).append(" : ").append(bonus.get(matchResult(i, result))).append("\n"));
        return builder.toString();
    }

    private int matchResult(int index, Map<Integer, Integer> result) {
        return result.get(index);
    }

    /** 이름 formatting */
    private static String formatNameLine(Names names) {
        StringBuilder sb = new StringBuilder();
        for (Name name : names.unmodifiableNames()) {
            sb.append(" ")
              .append(padLeft(name.toString()));
        }
        return sb.toString();
    }

    /** 사다리 한 행을 formatting */
    private static String formatLadderLine(Line line) {
        StringBuilder sb = new StringBuilder();
        sb.append(" ".repeat(WIDTH)).append(V);
        for (boolean conn : line.statues()) {
            String fill = conn
                ? String.valueOf(H).repeat(WIDTH)
                : " ".repeat(WIDTH);
            sb.append(fill).append(V);
        }
        return sb.toString();
    }

    /** 좌측 공백 */
    private static String padLeft(String s) {
        if (s.length() >= WIDTH) return s;
        return " ".repeat(WIDTH - s.length()) + s;
    }
}
