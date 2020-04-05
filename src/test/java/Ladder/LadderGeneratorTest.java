package Ladder;

import Ladder.domain.DefaultLadderGenerator;
import Ladder.domain.LadderGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderGeneratorTest {
    private LadderGenerator ladderGenerator;

    @BeforeEach
    void setUp() {
        ladderGenerator = new DefaultLadderGenerator();
    }

    @DisplayName("사람 수가 한명이면 진행 할 수 없다.")
    @Test
    void errorOnMinimumPeopleCount() {
        assertThatThrownBy(()-> ladderGenerator.generate(1, 10))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
