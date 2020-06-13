package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class HeightTest {

    @Test
    @DisplayName("높이 생성 테스트")
    void create(){
        Height height = Height.from(5);
        assertThat(height).isEqualTo(Height.from(5));
    }
    @Test
    @DisplayName("높이 생성 예외 테스트")
    void exception(){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Height.from(-1));
    }
}
