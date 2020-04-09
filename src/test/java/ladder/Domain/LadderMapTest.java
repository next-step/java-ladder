package ladder.Domain;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderMapTest {

    @ParameterizedTest
    @ValueSource(strings = "pobi,honux,crong,jk", "pobi,honux,crong", "pobi,honux")
    void createLadderMapTest(String input) {
        Users uesrs = Users.of(input);
        int highest = 4;
        MoveStrategy moveStrategy = () -> true;

        LadderMap ladderMap = LadderMap.of(uesrs, highest, moveStrategy);

        ladderMap.toList().forEach(line -> {
            assertThat(line).isEqualTo(Line.of(4, moveStrategy));
        });
    }
}
