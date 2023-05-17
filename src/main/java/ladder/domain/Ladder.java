package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final LadderRow[] rows;
    private final List<String> participantNames;
    ;
    public Ladder(int height, List<String> names) {
        validate(height, names.size());

        rows = Arrays.stream(new LadderRow[height])
                .map(row -> new LadderRow(names.size() - 1, RandomStrategy.getInstance()))
                .toArray(LadderRow[]::new);

        this.participantNames = names;
    }

    public Ladder(LadderRow[] ladderRows, List<String> names) {
        rows = ladderRows;
        this.participantNames = names;
    }


    public int getResultPosition(String name) {
        int curPosition = findIndex(name);
        for (int i = 0; i < rows.length; i++) {
            curPosition = rows[i].move(curPosition);
        }

        return curPosition;
    }

    private int findIndex(String name) {
        return IntStream.range(0, participantNames.size())
                .filter(i -> participantNames.get(i).equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이름입니다."));
    }

    private static void validate(int height, int personSize) {
        if (height < 0 || personSize < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }


    public String print() {
        return Arrays.stream(rows)
                .map(row -> row.print())
                .reduce("", (left, right) -> left + right + "\n");
    }
}
