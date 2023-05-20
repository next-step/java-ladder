package nextstep.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HeightTest {

    @Test
    @DisplayName("Height_생섣_테스트")
    public void Height_생섣_테스트(){
        assertThat(new Height(3)).isEqualTo(new Height("3"));
        assertThatThrownBy(() -> new Height(1)).isInstanceOf(IllegalArgumentException.class);
    }
}
