package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.strategy.LadderGenerateStrategy;
import org.junit.jupiter.api.Test;

class LineTest {
    @Test
    void 다라_생성() {
        Users users = new Users(List.of(new UserName("hwan2"), new UserName("hwan3"), new UserName("hwan4")));
        LadderGenerateStrategy alwaysGenerateStrategy = () -> true;
        Line line = Line.of(users, alwaysGenerateStrategy);
        assertThat(line).isNotNull();
    }
}
