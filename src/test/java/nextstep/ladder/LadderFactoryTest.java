package nextstep.ladder;

import nextstep.ladder.controller.LadderGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderFactoryTest {

    @Test
    void generate() {
        Ladder ladder = LadderFactory.generate(3, 3);

        System.out.println(ladder.getHorizontalLines());
    }
}