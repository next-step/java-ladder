package step1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

class LadderGeneratorTest {

    @Test
    @DisplayName("사다리 생성기가 에러 없이 정상적으로 생성되는지 테스트.")
    void generate() {
        then(LadderGenerator.generate(3, new Height(3))).isInstanceOf(Ladder.class);
    }
}