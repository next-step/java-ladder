package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantTest {

    @DisplayName("참여자 이름 empty")
    @ParameterizedTest
    @MethodSource("provideNameEmpty")
    void nameEmptyOrNull(String name) {
        assertThatThrownBy(() -> {
            Participant.of(name);
        }).isInstanceOf(LadderException.class)
                .hasMessage("이름으로 빈값이 올 수 없습니다.");
    }

    private static Stream<Arguments> provideNameEmpty() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of(" "),
                Arguments.of(new String())
        );
    }

    @DisplayName("참여자 이름 5글자 초과")
    @ParameterizedTest
    @ValueSource(strings = {"Donald", "William", "Hannah", "Olivia"})
    void nameOverFive(String name) {
        assertThatThrownBy(() -> {
            Participant.of(name);
        }).isInstanceOf(LadderException.class)
                .hasMessage("이름의 길이는 5글자까지 허용됩니다.");
    }
}
