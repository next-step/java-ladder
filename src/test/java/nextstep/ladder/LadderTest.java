package nextstep.ladder;

import nextstep.ladder.domain.ParticipantName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리타기 테스트")
public class LadderTest {

    @Test
    @DisplayName("참가자 이름이 최대 길이를 초과하면 예외를 던진다.")
    void validateParticipantNameLength_test() {
        String name = "NewJeans";

        assertThatThrownBy(() -> new ParticipantName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("참가자 이름이 영문이 아닌 문자가 포함되어 있다면 예외를 던진다.")
    void validateParticipantAlphabetName_test() {
        String name = "2NE1";

        assertThatThrownBy(() -> new ParticipantName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("참가자의 이름이 null이거나 빈 문자일 경우 예외를 던진다.")
    void validateParticipantNameNullAndEmpty_test(String name) {
        assertThatThrownBy(() -> new ParticipantName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
