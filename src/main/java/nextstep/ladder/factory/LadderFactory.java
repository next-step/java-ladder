package nextstep.ladder.factory;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Name;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderFactory {

    private LadderFactory() {
    }

    public static Ladder create(List<String> names,
                                int height,
                                Supplier<Boolean> isDraw) {
        List<Name> playerNames = creatNames(names);
        return new Ladder(playerNames, createLines(playerNames, new Height(height), isDraw));
    }

    private static List<Name> creatNames(List<String> names) {
        return names.stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }

    private static List<Line> createLines(List<Name> playerNames,
                                          Height ladderheight,
                                          Supplier<Boolean> isDraw) {
        return IntStream.range(0, ladderheight.height())
                .mapToObj(value -> createLine(playerNames, isDraw))
                .collect(Collectors.toList());
    }

    private static Line createLine(List<Name> playerNames,
                                   Supplier<Boolean> isDraw) {
        Line line = new Line(playerNames.size());
        IntStream.range(0, playerNames.size())
                .filter(line::canDraw)
                .forEach(i -> line.draw(i, isDraw.get()));

        return line;
    }
}
