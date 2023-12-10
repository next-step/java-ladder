package com.fineroot.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.fineroot.ladder.engine.Ladder;
import com.fineroot.ladder.engine.Positions;
import com.fineroot.ladder.factory.LadderFactoryBean;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MyLadderTest {

    @Test
    @DisplayName("MyLadder 생성")
    void create() {
        Ladder ladder = LadderFactoryBean.createLadderFactory().create(4, 5);
        assertThat(ladder).isInstanceOf(MyLadder.class);
    }

    @Test
    @DisplayName("MyLadder toString")
    void toStringTest() {
        Ladder ladder = LadderFactoryBean.createLadderFactory().create(4, 5);
        assertThat(ladder.toString()).isInstanceOf(String.class);
    }

    @ParameterizedTest
    @DisplayName("전체 실행 결과")
    @CsvSource({"0,꽝", "1,3000", "2,꽝", "3,5000"})
    void resultAll(int actual, String expected) {
        Rewards rewards = Rewards.fromString("꽝,5000,꽝,3000");
        MyLadder myLadder = new MyLadder(Arrays.stream(
                        new Boolean[][]{
                                {true, false, true},
                                {false, true, false},
                                {true, false, false},
                                {false, true, false},
                                {true, false, true}})
                .map(e -> new MyLineCreator(new MyBarCreator()).create(e))
                .collect(Collectors.toList()), 4);

        Positions positions = myLadder.playResult();

        assertThat(positions.matchString(rewards::rewardString, actual)).isEqualTo(expected);
    }
}
