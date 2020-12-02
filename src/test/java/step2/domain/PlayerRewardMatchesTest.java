package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerRewardMatchesTest {
    private PlayerRewardMatches playerRewardMatches;

    @BeforeEach
    void setUp() {
        playerRewardMatches = PlayerRewardMatches.of(Arrays.asList(
                PlayerRewardMatch.of("a", "1"), PlayerRewardMatch.of("b", "2")));
    }


    @Test
    @DisplayName("플레이어들이 생성되는지 확인")
    void createPlayers() {
        //given
        assertThat(playerRewardMatches).isEqualTo(PlayerRewardMatches.of(Arrays.asList(
                PlayerRewardMatch.of("a", "1"), PlayerRewardMatch.of("b", "2"))));
    }

    @Test
    @DisplayName("플레이어가 리스트가 잘 생성되는지 확인")
    void createPlayersList() {
        //given
        assertThat(playerRewardMatches.getPlayerRewardMatches())
                .containsExactly(PlayerRewardMatch.of("a", "1"), PlayerRewardMatch.of("b", "2"));
    }

}