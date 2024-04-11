package ladder.service;

import ladder.domain.*;
import ladder.domain.factory.DestinationFactory;
import ladder.domain.factory.LadderFactory;
import ladder.domain.factory.PlayerFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @Test
    @DisplayName("사다리 게임 원하는 결과 조회 테스트")
    void wantedResultsTest(){
        final Players players = PlayerFactory.create(List.of("david", "J", "alex"));
        final Destinations destinations = DestinationFactory.create(List.of("none", "5000", "3000"));
        final Ladder ladder = LadderFactory.create(players, destinations, 2);
        final Players wantedPlayers = PlayerFactory.create(List.of("david", "J"));

        LadderGame ladderGame = new LadderGame();
        Map<Player, Destination> actual = ladderGame.wantedResults(ladder, wantedPlayers);

        assertThat(actual).hasSize(2);
    }
}
