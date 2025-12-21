package nextstep.ladder.domain.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

public class UsersTest {

    @Test
    void 참여자_정상_생성(){
        Users users = new Users("pobi,honux,crong,jk");
        assertThat(users.getUsers()).hasSize(4);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 참여자_null또는공백시_오류발생(String names){
        assertThatThrownBy(() -> new Users(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자는 입력은 필수입니다.");
    }
}
