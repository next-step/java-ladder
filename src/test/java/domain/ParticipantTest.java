package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantTest {

    @Test(expected = IllegalArgumentException.class)
    public void 참여자_이름은_5자_넘을_수_없음() {
        new Participant("123456");
    }

    @Test
    public void 포맷_출력() {
        Participant participant = new Participant("aaa");
        String expected = "   aaa";

        assertThat(participant.toString()).isEqualTo(expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void all_은_이름으로_사용_불가() {
        new Participant("all");
    }
}