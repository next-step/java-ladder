package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final Names names;
    private final Lines lines;
    private final Prizes prizes;

    public Ladder(List<String> names, int height, List<String> prizes) {
        this(names, height, new RandomRungGenerator(), prizes);
    }

    public Ladder(List<String> names, int height, RungGenerator rungGenerator, List<String> prizes) {
        validateSameSize(names, prizes);
        this.names = new Names(names);
        this.lines = new Lines(height, this.names.connectSize(), rungGenerator);
        this.prizes = new Prizes(prizes);
    }

    private void validateSameSize(List<String> names, List<String> results) {
        if (names.size() != results.size())
            throw new IllegalArgumentException("The size of names and results do not match");
    }

    public LadderResult run() {
        List<Integer> indexResult = lines.run(names.size());
        Map<String, String> result = new HashMap<>();
        for (int i = 0; i < indexResult.size(); i++) {
            result.put(names.get(i), prizes.get(indexResult.get(i)));
        }
        return new LadderResult(result);
    }

    public Lines getLines() {
        return lines;
    }

    public Names getNames() {
        return names;
    }

    public Prizes getPrizes() {
        return prizes;
    }
}
