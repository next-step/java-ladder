package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomLadderGeneratorTest {

    private LadderGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new RandomLadderGenerator();
    }

    @Test
    @DisplayName("참가자:3명, 높이:1 사다리 생성")
    void 사다리_생성() {
        Ladder ladder = generator.generateLadder(3, 1);
        Assertions.assertThat(ladder).isInstanceOf(Ladder.class);
    }

    @Test
    @DisplayName("참가자:3명, 높이:3 사다리 생성")
    void 사다리_생성_높이3() {
        Ladder ladder = generator.generateLadder(3, 3);
        Assertions.assertThat(ladder.getLines()).hasSize(3);
    }
}
