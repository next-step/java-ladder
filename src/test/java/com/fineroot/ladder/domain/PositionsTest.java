package com.fineroot.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.fineroot.ladder.engine.Positions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionsTest {
    @Test
    @DisplayName("Positions 생성")
    void create() {
        assertThat(Positions.fromIntArray(0,3,2,1)).isInstanceOf(Positions.class);
    }

    @Test
    void matchString() {
        Rewards rewards = Rewards.fromString("꽝,5000,꽝,3000");
        assertThat(Positions.fromIntArray(0,3,2,1).matchString(rewards::rewardString,0))
                .isEqualTo("꽝");
    }

    @Test
    void matchAllString() {
        Users users = Users.fromString("pobi,honux,crong,jk");
        Rewards rewards = Rewards.fromString("꽝,5000,꽝,3000");
        User user = User.from("pobi");
        assertThat(Positions.fromIntArray(0,3,2,1).matchAllString(users::userString, rewards::rewardString))
                .isEqualTo("pobi : 꽝\nhonux : 3000\ncrong : 꽝\njk : 5000");
    }
}
