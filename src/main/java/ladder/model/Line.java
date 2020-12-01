package ladder.model;

import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final static String LINE_ERROR_MESSAGE = "올바르지 못한 라인입니다.";

    private List<LadderItem> ladderItems;

    private Line(List<LadderItem> ladderItems) {
        this.ladderItems = ladderItems;
    }

    public static Line from(List<LadderItem> ladderItems) {
        if (isNotValid(ladderItems)) {
            throw new IllegalArgumentException(LINE_ERROR_MESSAGE);
        }

        return new Line(ladderItems);
    }

    private static boolean isNotValid(List<LadderItem> ladderItems) {
        if (ladderItems.size() == 1)
            return false;

        return IntStream.range(0, ladderItems.size() - 1)
                .mapToObj(idx -> window(idx, ladderItems))
                .reduce((x, y) -> x || y)
                .orElse(true);

    }

    private static boolean window(int idx, List<LadderItem> ladderItems) {
        LadderItem now = ladderItems.get(idx);
        LadderItem next = ladderItems.get(idx + 1);

        if (now.equals(LadderItem.HORIZONTAL)) {
            return now.equals(next);
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder(LadderItem.VERTICAL.getItem());

        ladderItems.stream()
                .map(this::partOfLine)
                .forEach(line::append);

        return line.toString();
    }

    private String partOfLine(LadderItem ladderItem) {
        return ladderItem.getItem() + LadderItem.VERTICAL.getItem();
    }
}
