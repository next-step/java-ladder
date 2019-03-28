package ladder.domain.member;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MemberTest {
    @Test
    public void 이름이_공백일_경우_IllegalArgumentException() {
        // given
        String name = "  ";

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Member(name));
    }

    @Test
    public void 이름이_5자를_초과할_경우_IllegalArgumentException() {
        // given
        String name = "MyName";

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Member(name));
    }
}
