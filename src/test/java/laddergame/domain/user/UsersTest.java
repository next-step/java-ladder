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

    @DisplayName("실행 결과의 개수가 참여 인원수와 맞지 않으면 에러 발생")
    @Test
    void no_match_user_number_create_results() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Users("pobi,honux,crong,jk", "꽝,30000"));
    }
}
