package nextstep.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParticipantTest {

    @DisplayName("이름은 5글자를 넘길 수 없다.")
    @Test
    void maxLengthIsFive() {
        Assertions.assertThatThrownBy(() -> new Participant("다섯글자넘기"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
