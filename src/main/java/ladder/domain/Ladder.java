package ladder.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> ladder;

    public Ladder(Names names, Height height) {
        this(ladderLine(names, height));
    }

    private Ladder(List<Line> ladder) {
        this.ladder = Collections.unmodifiableList(ladder);
    }

    private static List<Line> ladderLine(Names names, Height height) {
        int namesCount = names.size();
        int ladderHeight = height.value();
        return IntStream.range(0, ladderHeight)
                .mapToObj(i -> Line.from(namesCount))
                .collect(Collectors.toList());
    }

    public Winning playerByPrize(Names names, Prizes prizes) {
        Map<Name, Prize> winning = new LinkedHashMap<>();
        int loopNumber = names.size();
        for (int i = 0; i < loopNumber; i++) {
            winning.put(names.name(i), prizes.prize(position(i)));
        }
        return new Winning(winning);
    }

    private int position(int startPosition) {
        int position = startPosition;
        for (Line line : ladder) {
            position = line.position(position);
        }
        return position;
    }

    public Line findLine(int index) {
        return ladder.get(index);
    }

    public int size() {
        return ladder.size();
    }
}
