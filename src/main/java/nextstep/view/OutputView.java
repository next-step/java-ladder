package nextstep.view;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import nextstep.domain.Ladder;
import nextstep.domain.Line;

/**
 * 출력 클래스
 */
public class OutputView {
    private static final char V = '|';
    private static final char H = '-';

    /** 결과 */
    public void printResult(List<String> names, Ladder ladder, List<String> bonus) {
        System.out.println("사다리 결과");

        int width = calculateWidth(names);

        // 1) 이름 줄
        System.out.println(formatNameLine(names, width));

        // 2) 사다리 줄
        ladder.lines().forEach(line ->
            System.out.println(formatLadderLine(line, width))
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

    /** 최대 이름 길이를 계산 */
    private static int calculateWidth(List<String> names) {
        return names.stream()
            .mapToInt(String::length)
            .max()
            .orElse(0);
    }

    /** 이름 formatting */
    private static String formatNameLine(List<String> names, int width) {
        StringBuilder sb = new StringBuilder();
        for (String name : names) {
            sb.append(" ")
                .append(padLeft(name, width));
        }
        return sb.toString();
    }

    /** 좌측 공백 */
    private static String padLeft(String s, int width) {
        if (s.length() >= width)
            return s;
        return " ".repeat(width - s.length()) + s;
    }

    /** 사다리 한 행을 formatting */
    private static String formatLadderLine(Line line, int width) {
        StringBuilder sb = new StringBuilder();
        sb.append(" ".repeat(width)).append(V);
        for (boolean conn : line.rowStatus()) {
            String fill = conn
                ? String.valueOf(H).repeat(width)
                : " ".repeat(width);
            sb.append(fill).append(V);
        }
        return sb.toString();
    }
}
