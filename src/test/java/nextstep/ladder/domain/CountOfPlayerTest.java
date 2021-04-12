package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CountOfPlayerTest {

    @Test
    @DisplayName("정수를 입력받아 플레이어 수를 의미하는 값 객체를 생성한다.")
    public void create() throws Exception {
        CountOfPlayer countOfPlayer = new CountOfPlayer(5);
        assertThat(countOfPlayer).isEqualTo(new CountOfPlayer(5));
    }
}
