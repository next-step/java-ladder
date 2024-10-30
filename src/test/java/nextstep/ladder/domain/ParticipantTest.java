package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantTest {

    @Test
    void 이름_5글자_초과() {
        assertThatThrownBy(() -> {
            new Participant("ByeongJoon");
        }).hasMessage("이름은 최대5글자까지 허용합니다.");
    }
}
