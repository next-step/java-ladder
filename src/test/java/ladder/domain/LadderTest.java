package ladder.domain;

import ladder.domain.factory.DestinationFactory;
import ladder.domain.factory.LadderFactory;
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
        final Players players = PlayerFactory.create(List.of("david", "J"));
        final Destinations destinations = DestinationFactory.create(List.of("none", "5000"));
        final int height = 2;
        final Ladder ladder = LadderFactory.create(players, destinations, height);

        assertThat(ladder.width()).isEqualTo(1);
        assertThat(ladder.height()).isEqualTo(2);
    }

    @Test
    @DisplayName("사다리 생성 실패 테스트 (참가자 수 결과 수 불일치)")
    void ladderFailForUnavailableWidthTest(){
        assertThatThrownBy(() -> {
            final Players players = PlayerFactory.create(List.of("david", "J", "alex"));
            final Destinations destinations = DestinationFactory.create(List.of("none", "5000"));
            final int height = 2;

            LadderFactory.create(players, destinations, height);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 생성할 때는 참가자 수와 실행 결과 수는 같아야 합니다.");
    }
}
