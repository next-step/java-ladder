package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantsTest {

    @ParameterizedTest
    @ValueSource(strings = {"a,b,c,d", "a, b, c, d"})
    @DisplayName("참가자 생성 기능")
    void createParticipants(String input) {
        String[] splitNames = input.split(",");

        assertThat(Participants.init(splitNames))
                .isInstanceOf(Participants.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {",", ",,"})
    @DisplayName("참가자가 없을 때 에러 리턴")
    void noParticipantsErrorTest(String input) {
        String[] splitNames = input.split(",");

        assertThatThrownBy(() -> Participants.init(splitNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자 이름을 입력해주세요");
    }

    @Test
    @DisplayName("같은 참가자가 있을 때 에러 리턴")
    void hasSameNameErrorTest() {
        String[] splitNames = "a,a,b".split(",");

        assertThatThrownBy(() -> Participants.init(splitNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("같은 이름을 입력했습니다.");
    }

}
