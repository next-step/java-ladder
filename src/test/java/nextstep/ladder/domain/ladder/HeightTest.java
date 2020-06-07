package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HeightTest {

    @Test
    @DisplayName("높이 생성 테스트")
    void create(){
        Height height = Height.of(5);
        assertThat(height).isEqualTo(Height.of(5));
    }
}
