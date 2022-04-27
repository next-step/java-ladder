package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class UserNameTest {

    @Test
    void create() {
        UserName userName = new UserName("wang");
        assertThat(userName).isEqualTo(new UserName("wang"));
    }

    @Test
    void invalidUserName() {
        assertThatThrownBy(() -> new UserName("WangTak"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
