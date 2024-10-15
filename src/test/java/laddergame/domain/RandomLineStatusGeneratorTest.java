package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLineStatusGeneratorTest {

    @DisplayName("사다리의 가로줄 유무를 랜덤한 boolean 값으로 관리한다")
    @Test
    void createRandomLineStatus(){
        RandomLineStatusGenerator generator = new RandomLineStatusGenerator();

        assertThat(generator.generate()).isIn(true, false);
    }

}