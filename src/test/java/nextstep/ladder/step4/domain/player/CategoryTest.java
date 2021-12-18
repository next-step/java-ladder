package nextstep.ladder.step4.domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CategoryTest {

    @ParameterizedTest
    @CsvSource(value = {"꽝,성공,꽝,꽝:4", "꽝,성공:2", "꽝,성공,꽝:3"}, delimiter = ':')
    @DisplayName("생성 성공")
    void create(String input, int playerCount) {
        assertThat(Category.of(new StringAsSplit(input), playerCount)).isInstanceOf(Category.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"꽝,성공,꽝,꽝:3", "꽝,성공:3", "꽝,성공,꽝:4"}, delimiter = ':')
    @DisplayName("플레이어 수와 결과가 다를 시 예외처리")
    void sizeException(String input, int playerCount) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Category.of(new StringAsSplit(input), playerCount));
    }

}
