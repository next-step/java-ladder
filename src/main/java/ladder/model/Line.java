package ladder.model;

import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final static String LINE_ERROR_MESSAGE = "올바르지 못한 라인입니다.";
    private final static String LINE_ERROR_MESSAGE_ILLEGAL_LINE_SIZE = "사다리 아이템은 2개 이상이여야 합니다.";
    private List<LadderItem> ladderItems;

    private Line(List<LadderItem> ladderItems) {
        this.ladderItems = ladderItems;
    }

    public static Line from(List<LadderItem> ladderItems) {
        validateLine(ladderItems);
        return new Line(ladderItems);
    }

    private static void validateLine(List<LadderItem> ladderItems) {
        if (ladderItems.size() == 1) {
           return;
        }

        boolean hasInvalidLadderItem = IntStream.range(0, ladderItems.size() - 1)
                .mapToObj(idx -> window(idx, ladderItems))
                .reduce((x, y) -> x || y)
                .orElse(Boolean.TRUE);

        if (hasInvalidLadderItem) {
            throw new IllegalArgumentException(LINE_ERROR_MESSAGE);
        }
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
