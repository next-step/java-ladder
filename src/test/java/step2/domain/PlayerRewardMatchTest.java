package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerRewardMatchTest {

    private PlayerRewardMatch playerRewardMatch;

    @BeforeEach
    void setUp() {
        playerRewardMatch = PlayerRewardMatch.of("a", "1");

    }

    @Test
    @DisplayName("상품과 상품 이름을 잘 생성하는지 확인한다.")
    void create() {
        assertThat(playerRewardMatch).usingRecursiveComparison().isEqualTo(PlayerRewardMatch.of("a", "1"));
    }

    @Test
    @DisplayName("플레이어 이름 확인")
    void matchPlayerName() {

        assertThat(playerRewardMatch.getPlayerGameName()).isEqualTo("a");
    }

    @Test
    @DisplayName("게임 리워드 확인")
    void matchRewardName() {
        assertThat(playerRewardMatch.getRewardName()).isEqualTo("1");
    }
}