package ladder.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<LadderLine> ladder;

    public Ladder(Names names, Height height) {
        this(ladderLine(names, height));
    }

    private Ladder(List<LadderLine> ladder) {
        this.ladder = Collections.unmodifiableList(ladder);
    }

    public static List<LadderLine> ladderLine(Names names, Height height) {
        int namesCount = names.size();
        int ladderHeight = height.value();
        return IntStream.range(0, ladderHeight)
                .mapToObj(i -> LadderLine.init(namesCount))
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
        for (LadderLine line : ladder) {
            position = line.move(position);
        }
        return position;
    }

    public LadderLine findLine(int index) {
        return ladder.get(index);
    }

    public int size() {
        return ladder.size();
    }
}
