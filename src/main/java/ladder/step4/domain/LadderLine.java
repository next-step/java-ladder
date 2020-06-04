package ladder.step4.domain;

import ladder.step4.domain.strategy.LadderLineStrategy;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LadderLine {
    private final List<Boolean> lines;

    private LadderLine(List<Boolean> lines) {
        this.lines = lines;
    }

    public static LadderLine of(int countOfPerson, LadderLineStrategy strategy) {
        final boolean[] prev = {false};
        return IntStream.range(0, countOfPerson)
                        .mapToObj(v -> {
                            prev[0] = strategy.createLine(prev[0]);
                            return prev[0];
                        }).collect(collectingAndThen(toList(), LadderLine::new));
    }

    public Stream<Boolean> stream() {
        return lines.stream();
    }

    public boolean get (int index) {
      return lines.get(index);
    }
}
