package nextstep.ladder.domain.laddar;

import nextstep.ladder.domain.dto.RowDto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final List<LadderRow> ladderRows;

    private Ladder(final LadderGameConfig ladderGameConfig) {
        ladderRows = Stream.generate(() -> LadderRow.from(ladderGameConfig))
                           .limit(ladderGameConfig.getHeight())
                           .collect(Collectors.toUnmodifiableList());
    }

    public static Ladder from(final LadderGameConfig ladderGameConfig) {
        return new Ladder(ladderGameConfig);
    }

    public List<RowDto> convert() {
        return ladderRows.stream()
                         .map(LadderRow::toDirections)
                         .map(RowDto::from)
                         .collect(Collectors.toUnmodifiableList());
    }
}
