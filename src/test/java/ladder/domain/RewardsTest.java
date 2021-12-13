package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RewardsTest {

    @DisplayName(",로 구분하여 Rewards 생성")
    @Test
    void create() {
        LadderStrings<Reward> names = new Rewards("꽝,5000,꽝,3000");

        assertThat(names.getValue()).hasSize(4);
    }

    @DisplayName("생성 파라미터는 null일 수 없음")
    @Test
    void create_null() {
        assertThatThrownBy(() -> new Rewards(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력이 null일 수 없습니다.");
    }

    @DisplayName("생성 파라미터는 비어있을 수 없음")
    @Test
    void create_empty() {
        assertThatThrownBy(() -> new Rewards(","))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력이 비어있을 수 없습니다.");
    }

}
