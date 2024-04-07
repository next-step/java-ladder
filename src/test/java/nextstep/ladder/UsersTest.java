package nextstep.ladder;

import nextstep.ladder.domain.Users;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class UsersTest {
    @Test
    @DisplayName("pobi, honux, crong, jk 값을 입력한 유저의 반환 유저수는 4명이다." )
    void getUserCount() {
        Users users = new Users("pobi", "honux", "crong", "jk");
        Assertions.assertThat(users.getUserCount()).isEqualTo(4);
    }

}
