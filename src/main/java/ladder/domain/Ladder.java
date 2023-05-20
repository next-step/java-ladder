package ladder.domain;

import java.util.Arrays;
import java.util.List;

public class Ladder {
    private final LadderRow[] rows;
    private final Participants participants;
    ;
    public Ladder(int height, List<String> names) {
        validate(height, names.size());

        rows = Arrays.stream(new LadderRow[height])
                .map(row -> new LadderRow(names.size() - 1, RandomStrategy.getInstance()))
                .toArray(LadderRow[]::new);

        this.participants = new Participants(names);
    }

    public Ladder(LadderRow[] ladderRows, List<String> names) {
        rows = ladderRows;
        this.participants = new Participants(names);
    }


    public int getResultPosition(String name) {
        int curPosition = participants.getIndexOf(name);
        for (int i = 0; i < rows.length; i++) {
            curPosition = rows[i].move(curPosition);
        }

        return curPosition;
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
