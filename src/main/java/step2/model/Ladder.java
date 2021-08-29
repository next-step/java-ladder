package step2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private static final int MIN_LADDER_HIGH = 1;

    private static int ladderHigh;
    private static int userCount;

    private ArrayList<Line> ladders;

    public Ladder(String high, int numberOfUser) {
        isBlank(high);
        isOverMinHigh(high);

        ladderHigh = getParseInt(high);
        userCount = numberOfUser;

        generateLine(new RandomLadderStrategy());
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
        this.ladders = new ArrayList<>();

        for (int i = 0; i < ladderHigh; i++) {
            ladders.add(new Line(userCount, ladderStrategy));
        }
    }

    public int getLineCount() {
        return ladders.stream()
                .map(Line::getLineCount)
                .reduce(0, Integer::sum);
    }

    public List<List<Boolean>> getLadder() {
        return ladders.stream()
                        .map(Line::getLine)
                        .collect(Collectors.toList());
    }
}
