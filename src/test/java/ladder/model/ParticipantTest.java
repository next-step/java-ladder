package ladder.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantTest {

    @Test
    public void 생성() {
        assertThat(Participant.from("생성테스트")).isNotNull();
    }

    @Test(expected = IllegalArgumentException.class)
    public void 생성_5자_초과() {
        Participant.from("초과테스트1");
    }
}