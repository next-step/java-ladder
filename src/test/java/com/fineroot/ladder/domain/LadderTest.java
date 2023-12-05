package com.fineroot.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderTest {

    @Test
    @DisplayName("Ladder 생성")
    void create() {
        Ladder ladder = Ladder.of(Users.fromString("a,b,c,d"), 5);
        assertThat(ladder).isInstanceOf(Ladder.class);
    }

    @Test
    @DisplayName("Ladder toString")
    void toStringTest() {
        Ladder ladder = Ladder.of(Users.fromString("aaaa,bbbbb,ccccc,ddd"), 5);
        assertThat(ladder.toString()).isInstanceOf(String.class);
    }

    @ParameterizedTest
    @DisplayName("전체 실행 결과")
    @CsvSource({"0,꽝","1,3000","2,꽝","3,5000"})
    void resultAll(int actual, String expected) {
        Rewards rewards = Rewards.fromString("꽝,5000,꽝,3000");
        Ladder ladder = Ladder.fromBooleanArrays(
                new Boolean[][]{{true, false, true},
                        {false, true, false},
                        {true, false, false},
                        {false, true, false},
                        {true, false, true}}, 4);

        Positions positions = ladder.resultAll();

        assertThat(positions.matchString(rewards::rewardString,actual)).isEqualTo(expected);
    }
}
