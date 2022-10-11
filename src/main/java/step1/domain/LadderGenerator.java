package step1.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGenerator {


    private LadderGenerator() {
    }

    public static Ladder generate(int lineCount, Height height) {
        List<Line> lines = new ArrayList<>();
        lines.add(createAllClosedLine(height));

        for (int i = 1; i < lineCount; i++) {
            Line beforeLine = lines.get(lines.size() - 1);
            lines.add(createLine(beforeLine));
        }

        return new Ladder(Lines.from(lines));
    }

    private static Line createAllClosedLine(Height height) {
        return Line.from(Bridge.createAllClosedBridges(height.getHeight()));
    }

    private static Line createLine(Line beforeLine) {
        int height = beforeLine.getHeight();
        List<Bridge> bridges = IntStream.range(0, height)
            .mapToObj(beforeLine::getBridgeByIdx)
            .map(Bridge::fromBeforeLineBridge)
            .collect(Collectors.toList());

        return Line.from(bridges);
    }
}
