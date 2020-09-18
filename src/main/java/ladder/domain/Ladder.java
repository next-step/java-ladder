package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<LadderLine> lines;

    public Ladder(int userCount, Height height) {
        this.lines = generateLines(userCount, height);
    }

    private List<LadderLine> generateLines(int userCount, Height height) {
        List<LadderLine> lineList =  IntStream.rangeClosed(Height.MIN_HEIGHT, height.getHeight())
                                    .mapToObj(count -> LadderLine.init(userCount))
                                    .collect(Collectors.toList());
        return Collections.unmodifiableList(lineList);
    }

    public List<LadderLine> getLadder(){
        return lines;
    }
}
