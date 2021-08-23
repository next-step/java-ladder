package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UsersTest {
    Users users = Users.valueOf("pobi,hj,seul");

    @Test
    @DisplayName("사용자 입력 성공 테스트")
    void 사용자_입력_성공_테스트() {
        Users users = Users.valueOf(Arrays.asList("pobi", "hj", "seul"));
        assertThat(this.users).isEqualTo(users);
    }

    @Test
    @DisplayName("사용자 입력 실패 테스트")
    void 사용자_입력_실패_테스트() {
        assertThatThrownBy(() -> Users.valueOf(Arrays.asList("pobi"))).isInstanceOf(RuntimeException.class);
    }
}
