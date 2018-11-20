package game.ladder.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Expects {

    private final Map<Position, Expect> expects;

    public Expects(List<Expect> expects) {
        this.expects = new LinkedHashMap<>();
        for (int i = 0; i < expects.size(); i++) {
            this.expects.put(new Position(i + 1), expects.get(i));
        }
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
