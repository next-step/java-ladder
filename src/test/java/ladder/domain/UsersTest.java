package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersTest {
    Users users = new Users("pobi,hj,seul");

    @Test
    @DisplayName("사용자 입력 성공 테스트")
    void 사용자_입력_성공_테스트() {
        Users users = new Users(Arrays.asList("pobi", "hj", "seul"));
        assertThat(this.users).isEqualTo(users);
    }
}
