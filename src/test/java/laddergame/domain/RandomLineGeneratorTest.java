package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLineGeneratorTest {

    @DisplayName("랜덤한 boolean 값으로 가로라인이 겹치치 않도록 라인을 생성한다")
    @Test
    void createRandomLineStatus(){
        RandomLineGenerator generator = new RandomLineGenerator();

        assertThat(generator.generate(2)).isIn(
                List.of(true, false),
                List.of(false, true),
                List.of(false, false)
        );
    }

}