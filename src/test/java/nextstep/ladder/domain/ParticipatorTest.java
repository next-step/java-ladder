package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipatorTest {

    @DisplayName("5글자가 넘는 사람이름을 입력받아도 앞에서부터 5글자만 부여합니다.")
    @Test
    void fiveName() {
        // given
        String inputName = "javajigi";
        // when
        Participator participator = new Participator(inputName);
        // then
        assertThat(participator).isEqualTo(new Participator("javaj"));
    }

}