package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class UserTest {
    @DisplayName("사용자 명 생성 테스트")
    @Test
    void create_사용자_명() {
        // given
        User user = User.valueOf("seok");
        // when
        User expected = User.valueOf("seok");
        // then
        assertThat(user).isEqualTo(expected);
    }

    @DisplayName("사용자 명 및 위치 정보 입력 테스트")
    @Test
    void create_사용자명_기본_위치정보() {
        // given
        User user = User.valueOf("seok", 1);
        // when
        User expected = User.valueOf("seok", 1);
        // then
        assertThat(user).isEqualTo(expected);
    }
}
