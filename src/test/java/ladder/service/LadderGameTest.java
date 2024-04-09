package ladder.service;

import ladder.domain.*;
import ladder.domain.factory.DestinationFactory;
import ladder.domain.factory.PlayerFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @Test
    @DisplayName("사다리 게임 생성 테스트")
    void ladderGameTest(){
        final Players players = PlayerFactory.create(List.of("david", "J", "alex"));
        final Destinations destinations = DestinationFactory.create(List.of("none", "5000", "3000"));
        final int height = 3;

        LadderGame ladderGame = new LadderGame(players, destinations, height);

        assertThat(ladderGame.players()).isEqualTo(players);
        assertThat(ladderGame.destinations()).isEqualTo(destinations);
        assertThat(ladderGame.ladder().width()).isEqualTo(players.count() - 1);
        assertThat(ladderGame.ladder().height()).isEqualTo(height);
    }

    @Test
    @DisplayName("사다리 게임 원하는 결과 조회 테스트")
    void wantedResultsTest(){
        final Players players = PlayerFactory.create(List.of("david", "J", "alex"));
        final Destinations destinations = DestinationFactory.create(List.of("none", "5000", "3000"));
        final Players wantedPlayers = PlayerFactory.create(List.of("david", "J"));

        LadderGame ladderGame = new LadderGame(players, destinations, 3);
        Map<Player, Destination> actual = ladderGame.wantedResults(wantedPlayers);

        assertThat(actual).hasSize(2);
    }
}
