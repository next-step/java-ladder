package nextstep.ladder.domain.user;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class UserTest {

    @Test
    public void Invalid_사람_이름길이() {
        assertThatIllegalArgumentException().isThrownBy(() -> new User("ABCDEF"));
    }
}
