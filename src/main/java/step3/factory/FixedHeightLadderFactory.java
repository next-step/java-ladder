package step3.factory;

import step3.Ladder;
import step3.Line;
import step3.util.SidelineGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FixedHeightLadderFactory implements LadderFactory {
    private final int height;
    private final SidelineGenerator sidelineGenerator;

    public FixedHeightLadderFactory(int height, SidelineGenerator sidelineGenerator) {
        this.height = height;
        this.sidelineGenerator = sidelineGenerator;
    }

    @Override
    public Ladder createLadder() {
        List<Line> lines = Stream.generate(() -> new Line(sidelineGenerator))
                .limit(height)
                .collect(Collectors.toList());

        return new Ladder(lines);
    }
}
