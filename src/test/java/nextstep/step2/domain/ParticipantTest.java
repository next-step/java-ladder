package nextstep.step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantTest {

    @Test
    void 문자열과_Name으로_참여자를_생성한다() {
        final String name = "pobi";

        final var actual1 = new Participant(name);
        final var actual2 = new Participant(new Name(name));

        assertThat(actual1.toNameString()).isEqualTo(actual2.toNameString());
    }
}
