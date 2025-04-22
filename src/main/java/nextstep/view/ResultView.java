package nextstep.view;

import nextstep.domain.Line;
import nextstep.util.StringUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class ResultView {

    public static final String EMPTY_LADDER = "     ";
    public static final String FULL_LADDER = "-----";
    public static final String PIPE = "|";
    public static final int MAX_NAME_LENGTH = 5;
    public static final String NL = System.lineSeparator();


    public static void printResult(String[] names, int ladderHeight, LinkedList<Line> lines) {

        StringBuilder sb = new StringBuilder();

        sb.append("실행 결과")
          .append(NL)
          .append(Arrays.stream(names)
                .map(name -> StringUtils.lpad(name, MAX_NAME_LENGTH))
                .reduce("", String::concat))
          .append(NL);

        IntStream.range(0, ladderHeight)
                .forEach(idx -> {
                    sb.append(EMPTY_LADDER)
                      .append(lines.stream()
                            .map(line -> draw(line.isPoint(idx)))
                            .reduce("", String::concat))
                      .append(PIPE)
                      .append(NL);
                });

        System.out.println(sb.toString());
    }

    private static String draw(boolean point) {
        return PIPE.concat(point ? FULL_LADDER : EMPTY_LADDER);
    }
}
