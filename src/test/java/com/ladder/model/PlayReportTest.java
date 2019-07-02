package com.ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class PlayReportTest {

    private Map<Player, Reward> playingResults = new HashMap<>();
    private PlayReport playReport = PlayReport.of(playingResults);

    {
        playingResults.put(Player.of(1, "a"), Reward.of("꽝"));
        playingResults.put(Player.of(2, "b"), Reward.of("1등"));
        playingResults.put(Player.of(3, "c"), Reward.of("2등"));
        playingResults.put(Player.of(4, "d"), Reward.of("꽝"));
    }

    @DisplayName("사다리 탄 결과 리포트를 작성한다")
    @Test
    void createPlayReport_success() {
        // then
        assertThat(playReport).isNotNull();
    }

    @DisplayName("플레이어 이름으로 검색 시 보상을 반환한다")
    @Test
    void findByPlayerName_stringPlayerName_success() {
        // given
        String searchPlayerName = "a";
        String expectedReward = playingResults.get(Player.of(1, searchPlayerName)).getReward();

        // when
        String result = playReport.searchByName(searchPlayerName);

        // then
        assertThat(result).isEqualTo(expectedReward);
    }

    @DisplayName("검색명이 ALL일 시 전체 결과를 반환한다")
    @Test
    void findByPlayerName_inputAll_success() {
        // given
        String playerName = "a";
        Player player = Player.of(1, playerName);
        String expectedRewardName = playingResults.get(player).getReward();

        // when
        Map<String,String> result = playReport.searchByAll();

        // then
        assertThat(result.get(playerName)).isEqualTo(expectedRewardName);
    }
}