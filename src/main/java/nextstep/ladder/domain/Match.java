package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Match {

    private static final int BEGIN_IDX = 0;
    private final Ladder ladder;
    private Map<String, String> results = new HashMap<>();

    public Match(Ladder ladder) {
        this.ladder = ladder;
    }

    public int resultIdx(int input) {

        return findDestinationIdx(input);
    }

    int findDestinationIdx(int startIdx) {
        int currentIdx = startIdx * 2;
        String[][] ladder = this.ladder.result();
        int rowCount = ladder.length;
        int columnLength = ladder[BEGIN_IDX].length;

        currentIdx = IntStream.range(BEGIN_IDX, rowCount)
                .reduce(currentIdx, (idx, i) -> {
                    String[] row = ladder[i];
                    if (isMovableToLeft(idx, row)) {
                        return idx - 2;
                    }
                    if (isMovableToRight(idx, row, columnLength)) {
                        return idx + 2;
                    }
                    return idx;
                });
        return currentIdx / 2;
    }

    private static boolean isMovableToLeft(int idx, String[] row) {
        return idx > BEGIN_IDX && "h".equals(row[idx - 1]);
    }

    private static boolean isMovableToRight(int idx, String[] row, int columnLength) {
        return idx < columnLength - 1 && "h".equals(row[idx + 1]);
    }

    public Map<String, String> value() {
        return results;
    }
}
