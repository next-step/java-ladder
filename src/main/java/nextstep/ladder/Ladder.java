package nextstep.ladder;

import java.util.Map;
import java.util.stream.Collectors;

public class Ladder {

    private final Lines lines;
    private final Names names;

    private Ladder(Lines lines, Names names) {
        this.lines = lines;
        this.names = names;
    }

    public static Ladder getRandomly(LadderHeight ladderHeight, Names names) {
        Lines lines = Lines.generateRandomly(ladderHeight, names.getListNames().size());
        return new Ladder(lines, names);
    }

    public Map<Name, Integer> getIndexAfterMove() {
        return names.getListNames().stream()
                .collect(Collectors.toMap(
                        name -> name,
                        name -> lines.getIndexAfterMove(names.getIndex(name))
                ));
    }

    public Lines getLines() {
        return lines;
    }

    public Names getNames() {
        return names;
    }
}
