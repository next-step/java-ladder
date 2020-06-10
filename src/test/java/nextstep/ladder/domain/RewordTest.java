package nextstep.ladder.domain;

import nextstep.ladder.exception.InputValueException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RewordTest {

    private Reword reword = Reword.newInstance("1000");

    @DisplayName("이름이 존재하지 않으면 생성할 수 없다.")
    @ParameterizedTest
    @MethodSource("generateInvalidName")
    void canNotCreateRewordIfNameIsBlank(String name) {
        assertThatThrownBy(() -> Reword.newInstance(name))
                .isInstanceOf(InputValueException.class);
    }

    static Stream<Arguments> generateInvalidName() {
        return Stream.of(
                Arguments.of((Object) null),
                Arguments.of(""),
                Arguments.of(" ")
        );
    }

    @DisplayName("객체를 생성할 수 있다.")
    @Test
    void canCreateReword() {
        assertThat(this.reword).isInstanceOf(Reword.class);
    }

    @DisplayName("보상명을 얻을 수 있다.")
    @Test
    void canToString() {
        assertThat(this.reword.toString()).isEqualTo("1000");
    }
}
