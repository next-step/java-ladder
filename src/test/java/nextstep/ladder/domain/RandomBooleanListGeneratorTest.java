package nextstep.ladder.domain;

import nextstep.ladder.exception.LineRowException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RandomBooleanListGeneratorTest {
    @ParameterizedTest
    @DisplayName("입력 받은 count - 1의 size를 가진 random List<Boolean>를 생성한다")
    @MethodSource
    void create(int count, int expected) {
        List<Boolean> list = new RandomBooleanListGenerator(count).generate();
        assertThat(list.size()).isEqualTo(expected);
    }

    static Stream<Arguments> create() {
        return Stream.of(
                Arguments.of(
                        2, 1
                ),
                Arguments.of(
                        3, 2
                )
        );
    }

    @ParameterizedTest
    @DisplayName("입력받는 count가 2 이하라면 예외가 발생한다")
    @ValueSource(ints = {-1, 0, 1})
    void sizeException(int count) {
        assertThatThrownBy(() -> new RandomBooleanListGenerator(count)).isInstanceOf(LineRowException.class);
    }
}