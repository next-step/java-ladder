package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {

    @Test
    @DisplayName("User 생성 성공 테스트")
    void User_생성_성공_테스트() {
        Name user = new Name("hj");
        assertThat(user).isEqualTo(new Name("hj"));
    }

    @Test
    @DisplayName("User 이름 길이 초과 생성 실패 테스트")
    void 이름_길이_초과_생성_실패_테스트() {
        assertThatThrownBy(() -> new Name("hjjang"))
                .isInstanceOf(RuntimeException.class);
    }
}
