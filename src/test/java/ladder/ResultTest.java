package ladder;

import ladder.domain.Result;
import ladder.domain.Reward;
import ladder.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultTest {
    private Map<User, Reward> userRewardMap = new HashMap<>();
    private Result result;
    private User user = new User("pobi", 0);
    private User user2 = new User("crong", 1);
    private User user3 = new User("hounx", 2);

    @BeforeEach
    void setup() {
        Reward reward = new Reward(0, "1000");
        Reward reward2 = new Reward(1, "2000");
        userRewardMap.put(user, reward);
        userRewardMap.put(user2, reward2);
        result = new Result(userRewardMap);
    }

    @Test
    @DisplayName("특정 회원의 결과값을 제대로 가져오는지")
    public void getIndividualResult() {
        assertThat(result.getIndividualResult(user)).isEqualTo("1000");
    }

    @Test
    @DisplayName("설정 안된 회원 에러 나는지")
    public void notUser() {
        assertThatThrownBy(() -> result.getIndividualResult(user3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 유저의 이름으로 결과를 찾을 수 없습니다.");
    }

}
