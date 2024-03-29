package ladder2.domain.factory;

import static ladder2.domain.Link.LEFT_LINK;
import static ladder2.domain.Link.NO_LINK;
import static ladder2.domain.Link.RIGHT_LINK;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import ladder2.domain.LadderColumn;
import ladder2.domain.LadderRow;
import ladder2.domain.Link;

public class LadderRowFactory {

    private static final String CAN_NOT_BE_INSTANCE_EXCEPTION_MESSAGE = "인스턴스화 불가 클래스입니다";
    private static final Random random = new Random();

    private LadderRowFactory() {
        throw new AssertionError(CAN_NOT_BE_INSTANCE_EXCEPTION_MESSAGE);
    }

    public static LadderRow generate(int columnSize) {
        List<LadderColumn> columns = new ArrayList<>();
        for (int i = 0; i < columnSize; i++) {
            LadderColumn column = nextColumn(columns, i, columnSize);
            columns.add(column);
        }
        return new LadderRow(columns);
    }

    private static LadderColumn nextColumn(List<LadderColumn> columns, int index, int columnSize) {
        if (isPrevColumnLinkIsRight(columns)) {
            return new LadderColumn(index, LEFT_LINK);
        }
        boolean isLastColumn = columns.size() == columnSize - 1;
        if (isLastColumn) {
            return new LadderColumn(index, NO_LINK);
        }
        return new LadderColumn(index, randomLinkOf(NO_LINK, RIGHT_LINK));
    }

    private static boolean isPrevColumnLinkIsRight(List<LadderColumn> columns) {
        return prevColumn(columns)
            .map(LadderColumn::link)
            .filter(link -> link == RIGHT_LINK)
            .isPresent();
    }

    private static Optional<LadderColumn> prevColumn(List<LadderColumn> columns) {
        if (columns.isEmpty()) {
            return Optional.empty();
        }
        int lastIndex = columns.size() - 1;
        return Optional.ofNullable(columns.get(lastIndex));
    }

    private static Link randomLinkOf(Link... links) {
        int randomIndex = random.nextInt(links.length);
        return links[randomIndex];
    }
}
