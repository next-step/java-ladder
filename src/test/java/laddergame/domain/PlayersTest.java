package laddergame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {

    @DisplayName("사다리 게임의 플레이어는 최소 2명이상이어야 한다")
    @Test
    void limitPlayerCount(){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Players(List.of(new Player("name"))))
                .withMessage("사다리 게임의 플레이어는 최소 2명 이상이어야 합니다");
    }

}