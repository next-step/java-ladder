package nextstep.ladder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

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

    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyUserName(String userName) {
        assertThatThrownBy(() -> new UserName(userName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
