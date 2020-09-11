package step04.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @DisplayName("사다리 출력 테스트")
    @Test
    void print() {
        // given
        Ladder ladder = Ladder.withLines(new Ladder(new LadderHeight(5)),
                5, new RandomLadderMakeStrategy());

        // when
        System.out.println(ladder.printableLadderStatus());
    }
}
