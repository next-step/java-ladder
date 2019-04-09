package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test
    public void 유저생성_테스트() {
        Player result = new Player("hyerin");
        Assertions.assertThat(result.getName()).isEqualTo("hyerin");
    }
}