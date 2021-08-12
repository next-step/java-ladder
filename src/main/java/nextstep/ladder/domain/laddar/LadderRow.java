package nextstep.ladder.domain.laddar;

import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderRow {
    private static final int ZERO = 0;
    private static final int ONE = 1;

    private final RowBuilder rowBuilder;

    private LadderRow(final LadderGameContext ladderGameContext) {
        this.rowBuilder = RowBuilder.from(ladderGameContext);
        rowBuilder.createFirst(ladderGameContext);
        rowBuilder.createMiddle(ladderGameContext);
        rowBuilder.createLast();
    }

    public static LadderRow from(final LadderGameContext ladderGameContext) {
        return new LadderRow(ladderGameContext);
    }

    public List<Boolean> getLadderMap() {
        return rowBuilder.ladderColumns.stream()
                                       .map(LadderColumn::isRight)
                                       .collect(Collectors.toUnmodifiableList());
    }

    public void ride(final Player player) {
        final Position position = player.position();
        final LadderColumn ladderColumn = rowBuilder.ladderColumns.get(position.currentPosition());
        ladderColumn.ride(position);
    }

    private static class RowBuilder {
        private final List<LadderColumn> ladderColumns;

        private RowBuilder(final LadderGameContext ladderGameContext) {
            this.ladderColumns = new ArrayList<>(ladderGameContext.getLadderWidth());
        }

        private static RowBuilder from(final LadderGameContext ladderGameContext) {
            return new RowBuilder(ladderGameContext);
        }

        private void createFirst(final LadderGameContext ladderGameContext) {
            ladderColumns.add(LadderColumn.createFirst(ladderGameContext.getDirectionStrategy()));
        }

        private void createMiddle(final LadderGameContext ladderGameContext) {
            Stream.generate(() -> createNext(ladderGameContext))
                  .limit(getMiddleSize(ladderGameContext))
                  .forEach(ladderColumns::add);
        }

        private LadderColumn createNext(final LadderGameContext ladderGameContext) {
            return getLastColumn().createNext(ladderGameContext.getDirectionStrategy());
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

        private int getMiddleSize(final LadderGameContext ladderGameContext) {
            return Math.max(ladderGameContext.getMiddleColumnSize(), ZERO);
        }
    }
}
