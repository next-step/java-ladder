package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipationNamesTest {

    @DisplayName("입력된 참가자 이름은 빈 값, null 값을 입력하며 익셉션 처리한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void error_participation_create(final List<String> names) {

        assertThatThrownBy(() -> new ParticipationNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자 이름은 필수값입니다.");
    }
}
