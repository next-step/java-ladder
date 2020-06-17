package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class HeightTest {

    @Test
    @DisplayName("높이 생성 테스트")
    void create(){
        Height height = Height.from(5);
        assertThat(height).isEqualTo(Height.from(5));
    }

    @ValueSource(ints = {-1, 0})
    @Test
    @DisplayName("높이 생성 예외 테스트")
    void exception(int height){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Height.from(height));
    }
}
