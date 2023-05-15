package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final int height;
    private final int width;

    public static List<Line> of(List<String> participantsName, int ladderHeight) {
        Ladder ladder = new Ladder(participantsName.size(), ladderHeight);
        return ladder.create();
    }

    private Ladder(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public List<Line> create() {
        return IntStream.rangeClosed(1, height)
                .mapToObj(i -> new Line(width))
                .collect(Collectors.toList());
    }
}
