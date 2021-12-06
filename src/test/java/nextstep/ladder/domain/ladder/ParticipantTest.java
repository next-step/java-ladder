package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.exception.InvalidNameLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantTest {

    @DisplayName("이름의 길이는 1이상 5이하여야 한다.")
    @ParameterizedTest(name = "[{index}] name: {0}")
    @NullAndEmptySource
    @ValueSource(strings = {"긴이름긴이름"})
    void create_invalidNameLength(String name) {
        assertThatThrownBy(() -> new Participant(name))
                .isInstanceOf(InvalidNameLengthException.class);
    }

    @ParameterizedTest(name = "[{index}] name: {0}")
    @ValueSource(strings = {"귤", "감자", "무화과", "파인애플", "안녕하세요"})
    void equals(String name) {
        assertThat(new Participant(name)).isEqualTo(new Participant(name));
    }

}
