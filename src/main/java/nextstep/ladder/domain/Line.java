package nextstep.ladder.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Line {

    private List<Boolean> bridges = new ArrayList<>();

    public Line(int countOfPerson, BridgeStrategy strategy) {
        for (int i = 0; i < countOfPerson - 1; i++) {
            bridges.add(build(strategy));
        }
    }

    public Line(int countOfPerson) {
        for (int i = 0; i < countOfPerson - 1; i++) {
            Optional<Integer> prevIndex = Optional.ofNullable(i)
                    .map(o -> o - 1);

            Boolean expected = build(() -> new Random().nextBoolean());
            bridges.add(decide(prevIndex, expected));
        }
    }

    private static Boolean build(BridgeStrategy strategy) {
        return strategy.bridgeBuild();
    }

    private Boolean decide(Optional<Integer> prevIndex, Boolean expected) {
        return prevIndex.filter(i -> i >= 0)
                .map(i -> bridges.get(i))
                .map(b -> Boolean.TRUE.equals(b) ? Boolean.valueOf(false) : expected)
                .orElse(expected);
    }
}
