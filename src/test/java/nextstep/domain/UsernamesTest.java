package nextstep.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UsernamesTest {

    @Test
    void 유저이름들을_생성한다() {
        // given
        List<String> usernames = Arrays.asList("pobi", "honux", "crong");

        // when & then
        assertDoesNotThrow(() -> new Usernames(usernames));
    }

    @Test
    void 유저이름의_위치를_구한다() {
        // given
        Usernames usernames = new Usernames(List.of("pobi", "honux", "crong"));
        Username username = new Username("crong");

        // when
        int result = usernames.getUsernameIndex(username);

        // then
        assertThat(result).isEqualTo(2);
    }
}
