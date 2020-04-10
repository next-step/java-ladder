package ladder.domain.ladder.maker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RandomLadderMakerTest {

    @Test
    @DisplayName("랜덤한 라인을 잘 만 들어 주었는지 확인")
    void createCountTest() {
        assertThat(new RandomLadderMaker(10, 10).makeBarLines())
                .hasSize(10);
    }

    @ParameterizedTest
    @DisplayName("양수만 가능")
    @CsvSource(value = {"0,1", "-1,1", "1,0", "1,-1"})
    void countOver1Test(int size, int height) {
        assertThatThrownBy(() -> new RandomLadderMaker(size, height))
                .isInstanceOf(RuntimeException.class);
    }

}