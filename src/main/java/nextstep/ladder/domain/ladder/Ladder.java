package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.init.LadderInitInfo;
import nextstep.ladder.dto.RowDto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<Row> rows;

    private Ladder(LadderInitInfo ladderInitInfo) {
        validate(ladderInitInfo);

        rows = Stream.generate(() -> Row.init(ladderInitInfo))
                .limit(ladderInitInfo.getLadderHeight())
                .collect(Collectors.toList());
    }

    private void validate(LadderInitInfo ladderInitInfo) {
        if (Objects.isNull(ladderInitInfo)) {
            throw new IllegalArgumentException("LadderInitInfo can't be null");
        }
    }

    public static Ladder init(LadderInitInfo ladderInitInfo) {
        return new Ladder(ladderInitInfo);
    }

    public List<RowDto> getSteps() {
        return rows.stream()
                .map(Row::toSteps)
                .map(RowDto::from)
                .collect(Collectors.toList());
    }

}
