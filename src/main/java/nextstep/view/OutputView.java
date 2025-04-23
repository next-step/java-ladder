package nextstep.view;

import java.util.List;

import nextstep.domain.Ladder;
import nextstep.domain.Line;

/**
 * 출력 클래스
 */
public class OutputView {
    private static final char V = '|';
    private static final char H = '-';

    /** 결과 */
    public void printResult(List<String> names, Ladder ladder) {
        System.out.println("실행 결과");

        int width = calculateWidth(names);

        // 1) 이름 줄
        System.out.println(formatNameLine(names, width));

        // 2) 사다리 줄
        ladder.lines().forEach(line ->
            System.out.println(formatLadderLine(line, width))
        );
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

    /** 좌측 공백 */
    private static String padLeft(String s, int width) {
        if (s.length() >= width) return s;
        return " ".repeat(width - s.length()) + s;
    }
}
