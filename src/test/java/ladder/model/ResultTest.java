package ladder.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {

    private Users users;

    @BeforeEach
    void setUp() {
        users = new Users("dhlee,jwlee,gylee");
    }

    @Test
    @DisplayName("사다리 게임 참여 수에 맞지 않게 결과 값을 입력")
    void itemNotMatch() {
        String resultItem = "꽝,5000,2000,3000";
        Assertions.assertThatThrownBy(() -> new Result(users, resultItem))
                  .isInstanceOf(IllegalStateException.class)
                  .hasMessage("사다리 게임 결과 값은 게임 참여자 수와 같아야 합니다.");
    }


    @Test
    @DisplayName("결과 보고싶은 사람 선택 시 존재하지 않는 사람 입력")
    void notFoundUser(){
        String resultItem = "꽝,5000,2000";
        Result result = new Result(users, resultItem);
        User user = new User("yhlee");
        Ladder ladder = new Ladder(0, "5");
        Assertions.assertThatThrownBy(() -> result.getUserResult(user, ladder))
                  .isInstanceOf(IllegalStateException.class)
                  .hasMessage("사다리 게임에 참여한 사용자 이름이 아닙니다.");
    }


}
