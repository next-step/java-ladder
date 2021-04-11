package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HeightTest {

    @Test
    @DisplayName("높이를 입력받아 높이 객체를 생성한다.")
    public void create() throws Exception {
        Height height = new Height("5");
        assertThat(height).isEqualTo(new Height(5));
    }
}
