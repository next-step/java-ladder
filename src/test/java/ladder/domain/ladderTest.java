package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
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

}