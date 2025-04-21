package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    void 사다리_생성_테스트() {
        Ladder ladder = Ladder.of(1, new Participants(List.of(new Participant("aa"), new Participant("bb"))), always -> true);
        assertThat(ladder.getLines().get(0).getPoints()).contains(new Point(true));
    }

    @Test
    void 사다리_이동_테스트() {
        Ladder ladder = Ladder.of(1, new Participants(List.of(new Participant("aa"), new Participant("bb"))), always -> true);
        assertThat(ladder.move(0)).isEqualTo(1);
        assertThat(ladder.move(1)).isEqualTo(0);
    }
}