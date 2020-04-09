package ladder.Domain;


import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderMapTest {

    @Test
    void createLadderMapTest() {
        Users uesrs = Users.of("pobi,honux,crong,jk");
        int highest = 4;
        MoveStrategy moveStrategy = () -> true;

        LadderMap ladderMap = LadderMap.of(uesrs, highest, moveStrategy);

        ladderMap.toList().forEach(line -> {
            assertThat(line).isEqualTo(Line.of(4, moveStrategy));
        });
    }
}
