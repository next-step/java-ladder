package nextstep.ladder.domain.laddar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderRow {
    private static final int ZERO = 0;
    private static final int ONE = 1;

    private final RowBuilder rowBuilder;

    private LadderRow(final LadderGameConfig ladderGameConfig) {
        this.rowBuilder = RowBuilder.from(ladderGameConfig);
        rowBuilder.createFirst(ladderGameConfig);
        rowBuilder.createMiddle(ladderGameConfig);
        rowBuilder.createLast();
    }

    public static LadderRow from(final LadderGameConfig ladderGameConfig) {
        return new LadderRow(ladderGameConfig);
    }

    public List<Boolean> toDirections() {
        return rowBuilder.ladderColumns.stream()
                                       .map(LadderColumn::isRight)
                                       .collect(Collectors.toUnmodifiableList());
    }

    private static class RowBuilder {
        private final List<LadderColumn> ladderColumns;

        private RowBuilder(final LadderGameConfig ladderGameConfig) {
            this.ladderColumns = new ArrayList<>(ladderGameConfig.getWidth());
        }

        private static RowBuilder from(final LadderGameConfig ladderGameConfig) {
            return new RowBuilder(ladderGameConfig);
        }

        private void createFirst(final LadderGameConfig ladderGameConfig) {
            ladderColumns.add(LadderColumn.createFirst(ladderGameConfig.getDirectionStrategy()));
        }

        private void createMiddle(final LadderGameConfig ladderGameConfig) {
            Stream.generate(() -> createNext(ladderGameConfig))
                  .limit(getMiddleSize(ladderGameConfig))
                  .forEach(ladderColumns::add);
        }

        private LadderColumn createNext(final LadderGameConfig ladderGameConfig) {
            return getLastColumn().createNext(ladderGameConfig.getDirectionStrategy());
        }

        private void createLast() {
            ladderColumns.add(createLastColumn());
        }

        private LadderColumn createLastColumn() {
            return getLastColumn().createLast();
        }

        private LadderColumn getLastColumn() {
            return ladderColumns.get(ladderColumns.size() - ONE);
        }

        private int getMiddleSize(final LadderGameConfig ladderGameConfig) {
            return Math.max(ladderGameConfig.getMiddleSize(), ZERO);
        }
    }
}
