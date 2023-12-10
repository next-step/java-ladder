package nextstep.ladder.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class ParticipantTest {

    @Test
    public void 이름_5글자_이상일때_에러_반환_테스트() {
        assertThatThrownBy(() -> new Participant("aaaaaa"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
