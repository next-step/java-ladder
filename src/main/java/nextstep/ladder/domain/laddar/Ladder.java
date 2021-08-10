package nextstep.ladder.domain.laddar;

import nextstep.ladder.domain.dto.RowDto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final List<LadderRow> ladderRows;

    private Ladder(final LadderGameContext ladderGameContext) {
        ladderRows = Stream.generate(() -> LadderRow.from(ladderGameContext))
                           .limit(ladderGameContext.getHeight())
                           .collect(Collectors.toUnmodifiableList());
    }

    public static Ladder from(final LadderGameContext ladderGameContext) {
        return new Ladder(ladderGameContext);
    }

    public List<RowDto> convert() {
        return ladderRows.stream()
                         .map(LadderRow::toDirections)
                         .map(RowDto::from)
                         .collect(Collectors.toUnmodifiableList());
    }
}
