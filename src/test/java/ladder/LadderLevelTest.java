package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderLevelTest {

    @DisplayName("ladder level 은 bar 로 시작하지 않으면 exception 을 던진다")
    @Test
    void shouldBarAtFirst(){
        assertThatThrownBy(() -> new LadderLevel(Arrays.asList(
                LevelItem.step(),
                LevelItem.step(),
                LevelItem.bar()
        ))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("ladder level 은 bar 로 끝나지 않으면 exception 을 던진다")
    @Test
    void shouldBarAtLast(){
        assertThatThrownBy(() -> new LadderLevel(Arrays.asList(
                LevelItem.bar(),
                LevelItem.step(),
                LevelItem.step()
        ))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("ladder level 에서 step 은 연속해서 만들수 없다")
    @Test
    void shouldNotContinuesStep(){
        assertThatThrownBy(() -> new LadderLevel(Arrays.asList(
                LevelItem.bar(),
                LevelItem.step(),
                LevelItem.bar(),
                LevelItem.step(),
                LevelItem.bar()
        ))).isInstanceOf(IllegalArgumentException.class);
    }

}
