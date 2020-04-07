package ladder.domain.ladder;

import java.util.Arrays;

public enum Mark {
    MARK(0, "     |"),
    MARK_WIDTH_DASH(1,"-----|");

    private int value;
    private String ladder;

    public String draw() {
        return ladder;
    }

    Mark(int value, String ladder) {
        this.value = value;
        this.ladder = ladder;
    }

    public static String ofLadder(int value) {
        return Arrays.stream(Mark.values())
                .filter(v -> v.value==value)
                .map(Mark::draw)
                .findFirst()
                .orElse(null);
    }
}
