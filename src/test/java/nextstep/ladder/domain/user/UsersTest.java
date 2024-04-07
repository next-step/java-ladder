package nextstep.ladder.domain.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UsersTest {
    @Test
    @DisplayName("pobi, honux, crong, jk 값을 입력한 유저의 반환 유저수는 4명이다.")
    void getUserCount() {
        Users users = new Users("pobi", "honux", "crong", "jk");
        Assertions.assertThat(users.getUserCount()).isEqualTo(4);
    }

    @Test
    @DisplayName("크기가 0이거나 비어있으면 예외 발생")
    void invalidUsersTest() {
        Assertions.assertThatThrownBy(() -> new Users(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하지 않는 유저들의 객체 생성을 시도합니다");
    }


}
