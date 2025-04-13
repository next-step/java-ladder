package ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ParticipantTest {

    @ParameterizedTest
    @DisplayName("참여하는 사람에 이름을 1글자 이상에서 최대 5글자까지 부여할 수 있다")
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    void participantNameTest(String name) {
        Participant participant = new Participant(name);

        Assertions.assertThat(participant.getName()).isEqualTo(name);
    }

    @ParameterizedTest
    @DisplayName("참여하는 사람에 이름이 공백이거나 5글자를 초과하는 경우 에러를 던진다")
    @MethodSource("provideInvalidNames")
    void participantNameThrowTest(String name) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Participant(name))
                .withMessageContaining("이름은 공백이거나 5글자를 초과할 수 없습니다.");
    }

    static Stream<String> provideInvalidNames() {
        return Stream.of(null, "", " ", "abcdef");
    }

}