package nextstep.ladder.service;

import nextstep.ladder.domain.*;
import nextstep.ladder.wrapper.Ladder;
import nextstep.ladder.wrapper.Line;
import nextstep.ladder.wrapper.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderTest {

    @DisplayName("Ladder 생성 시 Height 일치 테스트")
    @Test
    void create_생성_테스트() {
        // given
        Participants participants = Participants.valueOf("12345", "1234");
        Height height = Height.valueOf(2);
        // when
        List<Line> ladder = Ladder.valueOf(participants, height).lines();
        int expected = Height.valueOf(2).size();
        // then
        assertThat(ladder.size()).isEqualTo(expected);
    }

    @DisplayName("Ladder 생성 시 line 설정까지 추가")
    @Test
    void create_전략_생성_테스트() {
        // given
        Participants participants = Participants.valueOf("user1", "user2");
        Height height = Height.valueOf(2);
        // when
        Ladder ladder = Ladder.valueOf(
                participants,
                height,
                countOfPerson -> Arrays.asList(Bar.init(), Bar.valueOf(true), Bar.valueOf(false)));
        Line line = ladder.lines().get(0);
        List<Bar> bars = line.points();
        // then
        assertAll(
                () -> assertThat(bars.get(0)).isEqualTo(Bar.init()),
                () -> assertThat(bars.get(1)).isEqualTo(Bar.valueOf(true)),
                () -> assertThat(bars.get(2)).isEqualTo(Bar.valueOf(false))
        );
    }
}
