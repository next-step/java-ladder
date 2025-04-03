package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersTest {
    @DisplayName("유저들 생성 테스트")
    @Test
    void create_user() {
        assertThat(new Users("pobi,honux,crong,jk"))
                .extracting("users")
                .asList()
                .hasSize(4);
    }
}
