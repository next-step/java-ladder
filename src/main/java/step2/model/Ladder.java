package step2.model;

import java.util.ArrayList;

public class Ladder {
    private int row;
    private int column;
    private ArrayList<Line> ladders;

    private static final int MIN_LADDER_HIGH = 1;

    public Ladder(String high, int numberOfUser) {
        isBlank(high);
        isOverMinHigh(high);

        row = getParseInt(high);
        column = numberOfUser;
        this.ladders = new ArrayList<>();
    }

    private int getParseInt(String high) {
        return Integer.parseInt(high.trim());
    }

    private void isBlank(String high) {
        if (high == null || high.trim().isEmpty()) {
            throw new IllegalArgumentException("아무것도 입력하지 않았습니다. 다시 입력해주세요");
        }
    }

    private void isOverMinHigh(String high) {
        if (getParseInt(high) < MIN_LADDER_HIGH) {
            throw new IllegalArgumentException("최소" + MIN_LADDER_HIGH + "이상 입력해주세요");
        }
    }

    public void generateLine(LadderStrategy ladderStrategy) {
        for (int i = 0; i <row; i++) {
            ladders.add(new Line(column, ladderStrategy));
        }
    }

    public int getLineCount() {
        int count = 0;
        for (Line line : ladders) {
            count += line.getLineCount();
        }
        return count;
    }
}
