package nextstep.refactor_ladder.doamin.generate;

import nextstep.refactor_ladder.domain.generate.LineGenerator;
import nextstep.refactor_ladder.strategy.RandomLadderStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LineGeneratorTest {
    @Test
    @DisplayName("라인 정상 생성 검증")
    void create() {
        assertDoesNotThrow(() -> LineGenerator.create(5, new RandomLadderStrategy()));
    }
}
