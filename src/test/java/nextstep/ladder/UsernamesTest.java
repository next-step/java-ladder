package nextstep.ladder;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UsernamesTest {
    @Test
    void 참여자없음() {
        assertThatThrownBy(() -> {
            new Usernames(new ArrayList<>());
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
