package ladder2.domain;

import static ladder2.domain.Link.LEFT_LINK;
import static ladder2.domain.Link.RIGHT_LINK;

import java.util.ArrayList;
import java.util.List;

public class LadderRow {

    private static final String INDEX_EXCEPTION_MESSAGE = "LadderColumn 위치 정보가 잘못되었습니다";
    private static final String EMPTY_EXCEPTION_MESSAGE = "LadderColumn이 1개 이상 있어야 합니다";
    private static final String LINK_TO_NULL_EXCEPTION_MESSAGE = "빈 곳을 Link하는 LadderColumn이 있습니다";
    private static final String LINK_ONEWAY_EXCEPTION_MESSAGE = "단방향 Link를 가진 LadderColumn이 있습니다";

    private final List<LadderColumn> columns;

    public LadderRow(List<LadderColumn> columns) {
        validate(columns);
        this.columns = columns;
    }

    private static void validate(List<LadderColumn> columns) {
        validateIndex(columns);
        validateNotEmpty(columns);
        validateLinkToNotNull(columns);
        validateLinkedTwoWay(columns);
    }

    private static void validateIndex(List<LadderColumn> columns) {
        for (int i = 0; i < columns.size(); i++) {
            LadderColumn column = columns.get(i);
            validateIndex(column, i);
        }
    }

    private static void validateIndex(LadderColumn column, int i) {
        if (column.index() != i) {
            throw new IllegalArgumentException(INDEX_EXCEPTION_MESSAGE);
        }
    }

    private static void validateNotEmpty(List<LadderColumn> columns) {
        if (columns.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_EXCEPTION_MESSAGE);
        }
    }

    private static void validateLinkToNotNull(List<LadderColumn> columns) {
        LadderColumn first = columns.get(0);
        LadderColumn last = columns.get(columns.size() - 1);
        if (first.link() == LEFT_LINK || last.link() == RIGHT_LINK) {
            throw new IllegalArgumentException(LINK_TO_NULL_EXCEPTION_MESSAGE);
        }
    }

    private static void validateLinkedTwoWay(List<LadderColumn> columns) {
        int secondFromBackIndex = columns.size() - 2;
        for (int i = 0; i <= secondFromBackIndex; i++) {
            LadderColumn current = columns.get(i);
            LadderColumn next = columns.get(i + 1);
            validateLinkedTwoWay(current, next);
        }
    }

    private static void validateLinkedTwoWay(LadderColumn current, LadderColumn next) {
        boolean violation = (current.link() == RIGHT_LINK && next.link() != LEFT_LINK)
            || (current.link() == LEFT_LINK && next.link() == LEFT_LINK);
        if (violation) {
            throw new IllegalArgumentException(LINK_ONEWAY_EXCEPTION_MESSAGE);
        }
    }

    public static LadderRow of(Link... links) {
        List<LadderColumn> columns = new ArrayList<>();
        for (int i = 0; i < links.length; i++) {
            LadderColumn column = new LadderColumn(i, links[i]);
            columns.add(column);
        }
        return new LadderRow(columns);
    }

    public int nextColumnIndex(int columnIndex) {
        LadderColumn column = columns.get(columnIndex);
        return column.nextIndex();
    }

    public int columnSize() {
        return columns.size();
    }
}
