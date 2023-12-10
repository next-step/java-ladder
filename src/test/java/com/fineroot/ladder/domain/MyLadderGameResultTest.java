package com.fineroot.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.fineroot.ladder.engine.Positions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MyLadderGameResultTest {

    @Test
    @DisplayName("LadderResult 생성")
    void create() {
        LadderGameResult ladderGameResult = new LadderGameResult(
                new UserRewardSet(Users.fromString("pobi,honux,crong,jk"), Rewards.fromString("꽝,5000,꽝,3000")),
                Positions.fromIntArray(0,3,2,1));
        assertThat(ladderGameResult.resultSting(User.from("pobi"))).isEqualTo("꽝");
    }

    @Test
    @DisplayName("유저 실행 결과 문자열")
    void resultSting() {
        LadderGameResult ladderGameResult = new LadderGameResult(
                new UserRewardSet(Users.fromString("pobi,honux,crong,jk"), Rewards.fromString("꽝,5000,꽝,3000")),
                Positions.fromIntArray(0,3,2,1));
        assertThat(ladderGameResult.resultSting(User.from("pobi"))).isEqualTo("꽝");
    }

    @Test
    @DisplayName("ALL 입력 결과 문자열")
    void toResultAllString() {
        LadderGameResult ladderGameResult = new LadderGameResult(
                new UserRewardSet(Users.fromString("pobi,honux,crong,jk"), Rewards.fromString("꽝,5000,꽝,3000")),
                Positions.fromIntArray(0,3,2,1));
        assertThat(ladderGameResult.resultSting(User.from("all"))).isEqualTo("pobi : 꽝\nhonux : 3000\ncrong : 꽝\njk : 5000");
    }
}
