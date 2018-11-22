package game.ladder.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Expects {

    private final Map<Position, Expect> expects;

    public Expects(List<Expect> expects) {
        this.expects = IntStream.range(0, expects.size()).mapToObj(Position::new)
                .collect(Collectors.toMap(Function.identity(), p -> expects.get(p.getValue()), (a, b) -> a, LinkedHashMap::new));
    }

    public Expect getExpect(Position position) {
        return Optional.ofNullable(this.expects.get(position))
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 Position 입니다."));
    }

    public int size() {
        return this.expects.size();
    }

    public String getStringExpects() {

        return this.expects.values().stream().map(Expect::formattedValue).collect(Collectors.joining());
    }

}
