package nextstep.laddergame.domain.ladder;

import java.util.Arrays;
import java.util.List;

public record Lines(List<Line> lineList) {

    public Lines(Line... lists) {
        this(Arrays.stream(lists).toList());
    }

}
