package laddergame.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UsersTest {
    @DisplayName("유저들 생성 테스트")
    @Test
    void create_user() {
        assertThat(new Users("pobi,honux,crong,jk", "1000,2000,꽝,꽝"))
                .extracting("results")
                .asList()
                .hasSize(4);
    }
}
