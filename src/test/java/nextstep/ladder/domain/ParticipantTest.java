package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ParticipantTest {

    @Test
    void create() {
        Participant siso = new Participant("siso");
        assertThat(siso).isEqualTo(new Participant("siso"));
    }

    @DisplayName("참가자의 이름은 비어있거나 빈 문자열 일 수 없습니다.")
    @ParameterizedTest
    @NullAndEmptySource
    void 빈문자열_또는_공백_일떄(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Participant(input);
        });
    }

    @DisplayName("참가자의 이름은 5글자를 초과하면 예외가 발생한다.")
    @Test
    void 이름이_5글자_초과_일떄() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Participant("abcdef");
        });
    }

    @Test
    void toStringTest() {
        assertThat(new Participant("pos").toString()).isEqualTo("pos   ");
    }

}