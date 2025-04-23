package ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final Names names;
    private final Lines lines;
    private final Prizes prizes;

    public Ladder(List<String> names, List<String> prizes, int height) {
        this(names, prizes, height, new RandomRungGenerator());
    }

    public Ladder(List<String> names, List<String> prizes, int height, RungGenerator rungGenerator) {
        validateSameSize(names, prizes);
        this.names = new Names(names);
        this.lines = new Lines(height, this.names.size(), rungGenerator);
        this.prizes = new Prizes(prizes);
    }

    private void validateSameSize(List<String> names, List<String> results) {
        if (names.size() != results.size())
            throw new IllegalArgumentException("The size of names and results do not match");
    }

    public Results getResults() {
        Map<String, String> results = IntStream.range(0, names.size())
                .mapToObj(this::getResult)
                .collect(Collectors.toMap(Result::getName, Result::getPrize));

        return new Results(results);
    }

    private Result getResult(int point) {
        return new Result(names.get(point), prizes.get(lines.moveLinesFrom(point)));
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
