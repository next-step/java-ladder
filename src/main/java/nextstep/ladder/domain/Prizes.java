package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

import nextstep.ladder.engine.FirstClassList;

public class Prizes extends FirstClassList<Prize> {
    private Prizes(final List<Prize> prizes) {
        super(prizes);
    }

    public static Prizes fromString(final List<String> results) {
        if (results == null) {
            throw new IllegalArgumentException("invalid results: cannot be null or empty");
        }

        RailCount.validate(results.size());

        return new Prizes(results.stream()
                .map(Prize::of)
                .collect(Collectors.toList()));
    }

    public Prizes mapByIndex(List<Integer> indexes) {
        return new Prizes(indexes.stream()
                .map(this::elementOf)
                .collect(Collectors.toList()));
    }

    @Override
    public String toString() {
        return "Results {" +
                super.toString() +
                '}';
    }
}
