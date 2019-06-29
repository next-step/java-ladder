package ladder.view;

import ladder.exception.PrintResultException;

import java.util.stream.IntStream;

public class ResultString {

    public static final String STEP = "|";
    private static final String CONNECT = "-";
    private static final String EMPTY = " ";

    public static String buildConnectString(int size) {

        return buildResultString(CONNECT, size);
    }

    public static String buildEmptyString(int size) {

        return buildResultString(EMPTY, size);
    }

    private static String buildResultString(String s, int size) {

        return IntStream.range(0, size)
                .mapToObj(i -> s)
                .reduce((s1, s2) -> s1 + s2)
                .orElseThrow(PrintResultException::new);
    }
}
