package com.fineroot.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.fineroot.ladder.engine.Positions;
import com.fineroot.ladder.utils.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UserRewardSetTest {
    @Test
    @DisplayName("UserRewardSet 생성")
    void create() {
        assertThat(new UserRewardSet(Users.fromString("pobi,honux,crong,jk"),
                Rewards.fromString("꽝,5000,꽝,3000")))
                .isInstanceOf(UserRewardSet.class);
    }

    @Test
    @DisplayName("UserRewardSet 생성시")
    void create_exception() {
        assertThatThrownBy(()->new UserRewardSet(Users.fromString("honux,crong,jk"),
                Rewards.fromString("꽝,5000,꽝,3000")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.USERS_REWARDS_SIZE_NOT_EQUAL.getMessage());
    }

    @Test
    void firstUsernameLength() {
        assertThat(new UserRewardSet(Users.fromString("pobi,honux,crong,jk"),
                Rewards.fromString("꽝,5000,꽝,3000")).firstUsernameLength())
                .isEqualTo(4);
    }

    @ParameterizedTest
    @DisplayName("유저 이름 -> 결과")
    @CsvSource({"'pobi','꽝'","'dudu','없는 유저입니다.'"})
    void rewardString(String actual, String expected) {
        Positions positions = Positions.fromIntArray(0,3,2,1);
        assertThat(new UserRewardSet(Users.fromString("pobi,honux,crong,jk"),
                Rewards.fromString("꽝,5000,꽝,3000")).rewardString(positions,User.from(actual)))
                .isEqualTo(expected);
    }

    @Test
    void userRewardAllString() {
        Positions positions = Positions.fromIntArray(0,3,2,1);
        assertThat(new UserRewardSet(Users.fromString("pobi,honux,crong,jk"),
                Rewards.fromString("꽝,5000,꽝,3000")).userRewardAllString(positions))
                .isEqualTo("pobi : 꽝\nhonux : 3000\ncrong : 꽝\njk : 5000");
    }
}
