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
        final Players players = PlayerFactory.create(List.of("david", "J", "lee"));
        final Ladder ladder = new Ladder(players, 5);

        assertThat(ladder.height()).isEqualTo(5);
        assertThat(ladder.width()).isEqualTo(2);

        assertThatThrownBy(() -> {
            Players onePlayer = PlayerFactory.create(List.of("david"));
            new Ladder(onePlayer, 2);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 생성에 필요한 참가자는 최소 2명 이상이어야 합니다.");

        assertThatThrownBy(() -> {
            new Ladder(players, 1);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이는 최소 2 이상이어야 합니다.");

    }
}
