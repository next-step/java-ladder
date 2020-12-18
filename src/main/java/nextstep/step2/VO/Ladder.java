package nextstep.step2.VO;

import nextstep.step2.service.LineGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> ladder;
    private final int ladderWidth;

    public Ladder(int width, int height) {
        this.ladderWidth = width;
        this.ladder = createLadder(height);
    }

    private List<Line> createLadder(int height) {
        return IntStream.range(0, height)
                .mapToObj(index -> LineGenerator.createLine(ladderWidth))
                .collect(Collectors.toList());
    }

    public List<Line> getLadder() {
        return ladder;
    }
}
