package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AttendeeTest {

    @Test
    public void 생성() {
        Attendee attendee = Attendee.create("pobi");
        assertThat(attendee).isNotNull();
    }

    @Test(expected = IllegalArgumentException.class)
    public void 생성_예외처리() {
        Attendee.create("abcdef");
    }
}