package nextstep.ladder.domain.laddar;

import nextstep.ladder.domain.dto.RowDto;
import nextstep.ladder.domain.player.Player;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final LadderGameContext context;

    private final List<LadderRow> ladderRows;

    private Ladder(final LadderGameContext ladderGameContext) {
        this.context = ladderGameContext;
        ladderRows = Stream.generate(() -> LadderRow.from(ladderGameContext))
                           .limit(ladderGameContext.getLadderHeight())
                           .collect(Collectors.toUnmodifiableList());
    }

    public static Ladder from(final LadderGameContext ladderGameContext) {
        return new Ladder(ladderGameContext);
    }

    public List<RowDto> convert() {
        return ladderRows.stream()
                         .map(LadderRow::getLadderMap)
                         .map(RowDto::from)
                         .collect(Collectors.toUnmodifiableList());
    }

    public int height() {
        return context.getLadderHeight();
    }

    public void ride(final Player player, final int depth) {
        ladderRows.get(depth).ride(player);
    }
}
