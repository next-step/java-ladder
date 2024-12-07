package ladder.domain.ns;

import ladder.domain.interfaces.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static ladder.domain.ns.NsPlayersTest.POBI_HONUX_CRONG_JK;
import static ladder.domain.ns.NsRewardsTest.꽝_5000_꽝_3000;
import static ladder.domain.wrapper.PlayerNameTest.*;
import static ladder.domain.wrapper.RewardNameTest.*;
import static org.assertj.core.api.Assertions.assertThat;

public class NsLadderTest {
    public static final int VERTICAL_LADDER_SIZE = 5;

    @Test
    @DisplayName("생성자로 사다리를 생성한다")
    void create() {
        Players players = new NsPlayers(POBI_HONUX_CRONG_JK);
        Line falseLine = new NsLine(players.size(), () -> false);
        Lines lines = new NsLines(List.of(falseLine, falseLine, falseLine, falseLine, falseLine));

        Ladder actual = new NsLadder(players, VERTICAL_LADDER_SIZE, () -> false);
        Ladder expected = new NsLadder(players, lines);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("라인목록을 조회한다")
    void getLines() {
        Players players = new NsPlayers(POBI_HONUX_CRONG_JK);
        Line falseLine = new NsLine(players.size(), () -> false);
        Lines lines = new NsLines(List.of(falseLine, falseLine, falseLine, falseLine, falseLine));

        Ladder ladder = new NsLadder(players, lines);
        Lines actual = ladder.getLines();

        assertThat(actual).isEqualTo(lines);
    }

    @Test
    @DisplayName("플레이어 목록을 조회한다")
    void getPlayers() {
        Players players = new NsPlayers(POBI_HONUX_CRONG_JK);
        Line falseLine = new NsLine(players.size(), () -> false);
        Lines lines = new NsLines(List.of(falseLine, falseLine, falseLine, falseLine, falseLine));

        Ladder ladder = new NsLadder(players, lines);
        Players actual = ladder.getPlayers();

        assertThat(actual).isEqualTo(players);
    }

    @Test
    @DisplayName("결과를 생성한다")
    void results() {
        Players arrivalPlayers = new NsPlayers(POBI_HONUX_CRONG_JK);
        Line falseLine = new NsLine(arrivalPlayers.size(), () -> false);
        Lines lines = new NsLines(List.of(falseLine, falseLine, falseLine, falseLine, falseLine));
        Ladder ladder = new NsLadder(arrivalPlayers, lines);
        Rewards rewards = new NsRewards(꽝_5000_꽝_3000, 4);

        Results actual = ladder.results(rewards);
        Results expected = new NsResults(Map.of(
                PLAYER_NAME_POBI, REWARD_NAME_꽝,
                PLAYER_NAME_HONUX, REWARD_NAME_5000,
                PLAYER_NAME_CRONG, REWARD_NAME_꽝,
                PLAYER_NAME_JK, REWARD_NAME_3000
        ));

        assertThat(actual).isEqualTo(expected);
    }
}
