package nextstep.step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParticipantNameTest {

    @DisplayName("참여자 이름이 5글자를 초과하면 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"amount, monster, steveJobs"})
    void participant_name_less_than_6(String name) {
        Assertions.assertThatThrownBy(() -> ParticipantName.from(name))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참여자 이름이 공백으로만 이루어지면 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "    "})
    void participant_name_not_blank(String blank) {
        Assertions.assertThatThrownBy(() -> ParticipantName.from(blank))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
