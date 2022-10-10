package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipationNameTest {

    @DisplayName("입력된 참가자 이름은 빈 값, null 값을 입력하며 익셉션 처리한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void error_participation_create(final String name) {

        assertThatThrownBy(() -> new ParticipationName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자 이름은 필수값입니다.");
    }

    @DisplayName("스페이스만 입력한 이름도 익셉션 처리한다.")
    @Test
    void error_participation_create2() {

        assertThatThrownBy(() -> new ParticipationName("     "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자 이름은 필수값입니다.");
    }

    @DisplayName("입력된 참가자 이름을 , 로 잘라서 목록으로 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"pobi:1", "pobi,:1", "pobi,crong:2", "pobi,crong,honux:3"}, delimiter = ':')
    void input_name(final String input, final int size) {

        final List<ParticipationName> participationNames = ParticipationName.from(input);

        assertThat(participationNames).hasSize(size);
    }

    @DisplayName("입력된 참가자 이름이 빈 값이 포함되어 있다면 익셉션 처리한다.")
    @ParameterizedTest
    @ValueSource(strings = {",pobi,", " ,pobi, "})
    void error_input_name(final String input) {

        assertThatThrownBy(() -> ParticipationName.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자 이름은 필수값입니다.");
    }
}
