package step4.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGenerator {


    private LadderGenerator() {
    }

    public static Ladder generate(int likeCnt, Height height) {
        List<Line> lines = new ArrayList<>();
        lines.add(createAllClosedLine(height));

        IntStream.range(1, likeCnt)
            .mapToObj(i -> lines.get(lines.size() - 1))
            .forEach(beforeLine -> lines.add(createLine(beforeLine)));

        return new Ladder(Lines.from(lines));
    }

    private static Line createAllClosedLine(Height height) {
        return Line.from(Bridge.createClosedBridges(height.getHeight()));
    }

    private static Line createLine(Line beforeLine) {
        int height = beforeLine.getHeight();
        List<Bridge> bridges = IntStream.range(0, height)
            .mapToObj(beforeLine::getBridgeByIdx)
            .map(Bridge::from)
            .collect(Collectors.toList());

        return Line.from(bridges);
    }
}
