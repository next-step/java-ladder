package ladder.domain.vo;

import ladder.domain.Destinations;
import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.factory.DestinationFactory;
import ladder.domain.factory.LadderFactory;
import ladder.domain.factory.PlayerFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderBodyTest {
    
    @Test
    @DisplayName("사다리 생성 테스트")
    void ladderBodyTest(){
        final LadderBody ladderBody = new LadderBody(1, 2);

        assertThat(ladderBody.width()).isEqualTo(1);
        assertThat(ladderBody.height()).isEqualTo(2);
    }

    @Test
    @DisplayName("사다리 생성 실패 테스트 (사다리 넓이 최소 1)")
    void ladderBodyFailForUnavailableWidthTest(){
        assertThatThrownBy(() -> {
            new LadderBody(0, 2);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 너비는 최소 1 이상이어야 합니다.");
    }

    @Test
    @DisplayName("사다리 생성 테스트 (사다리 높이 최소 2)")
    void ladderBodyFailForUnavailableHeightTest(){
        assertThatThrownBy(() -> {
            new LadderBody(1, 1);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이는 최소 2 이상이어야 합니다.");

    }
}
