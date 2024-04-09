package ladder.domain;

import ladder.domain.factory.PlayerFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {
    
    @Test
    @DisplayName("사다리 생성 테스트")
    void ladderTest(){
        final Ladder ladder = new Ladder(1, 2);

        assertThat(ladder.width()).isEqualTo(1);
        assertThat(ladder.height()).isEqualTo(2);
    }

    @Test
    @DisplayName("사다리 생성 실패 테스트 (사다리 넓이 최소 1)")
    void ladderFailForUnavailableWidthTest(){
        assertThatThrownBy(() -> {
            new Ladder(0, 2);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 넓이는 최소 1 이상이어야 합니다.");
    }

    @Test
    @DisplayName("사다리 생성 테스트 (사다리 높이 최소 2)")
    void ladderFailForUnavailableHeightTest(){
        assertThatThrownBy(() -> {
            new Ladder(1, 1);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이는 최소 2 이상이어야 합니다.");

    }
}
