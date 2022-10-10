package nextstep.ladder.domain;

import nextstep.ladder.dto.LineDto;

import java.util.List;
import java.util.stream.Collectors;

public class Result {

    private Result() {}

    public static List<LineDto> show(final Ladder ladder) {

        return ladder.getLines()
                .stream()
                .map(LineDto::from)
                .collect(Collectors.toList());
    }
}
