package nextstep.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsernamesTest {

    @Test
    void 유저이름들을_생성한다() {
        // given
        List<String> usernames = Arrays.asList("pobi", "honux", "crong");

        // when & then
        assertDoesNotThrow(() -> new Usernames(usernames));
    }
}
