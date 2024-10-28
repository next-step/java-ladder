package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Map;
import ladder.strategy.LadderGenerateStrategy;
import org.junit.jupiter.api.Test;

class ladderTest {
    @Test
    void 사다리_생성() {
        LadderGenerateStrategy alwaysGenerateStrategy = () -> true;
        Users users = new Users(List.of(new UserName("hwan2"), new UserName("hwan3"), new UserName("hwan4")));
        Ladder ladder = new Ladder(5, users, alwaysGenerateStrategy);
        assertThat(ladder).isNotNull();
    }

    @Test
    void 사다리_최소길이_검증() {
        LadderGenerateStrategy alwaysGenerateStrategy = () -> true;
        Users users = new Users(List.of(new UserName("hwan2"), new UserName("hwan3"), new UserName("hwan4")));
        assertThatThrownBy(() -> new Ladder(0, users, alwaysGenerateStrategy))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리타기() {
        LadderGenerateStrategy alwaysGenerateStrategy = () -> true;
        Users users = new Users(List.of(new UserName("hwan2"), new UserName("hwan3"), new UserName("hwan4")));
        Ladder ladder = new Ladder(3, users, alwaysGenerateStrategy);
        Map<Integer, Integer> map = ladder.rideLadder(3);

        assertThat(map.size()).isEqualTo(3);
        assertThat(map.get(0)).isEqualTo(1);
        assertThat(map.get(1)).isEqualTo(0);
        assertThat(map.get(2)).isEqualTo(2);
    }

    /*
      hwan2    hwan3    hwan4
        |-----|     |
        |-----|     |
        |-----|     |
     */
}
