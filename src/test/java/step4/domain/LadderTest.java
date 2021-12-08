package step4.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    void 사다리를_생성한다() {
        //given
        Ladder ladder = Ladder.of(LadderInfo.of(4, 5));
        //when & then
        assertThat(ladder.size()).isEqualTo(5);
        assertThat(ladder).isNotNull();
    }

    @Test
    void 사다리_전체를_실행한다() {
        //given
        Ladder ladder = Ladder.of(LadderInfo.of(4, 5));
        //when
        List<Position> positions = ladder.startAll();
        //then
        assertThat(positions.stream()
                .map(Position::position)
                .distinct().count()).isEqualTo(4);
    }

    @Test
    void 사다리_하나를_실행한다() {
        //given
        Ladder ladder = Ladder.of(LadderInfo.of(4, 5));
        //when
        Position position = ladder.startBy(0);
        //then
        assertThat(position.position()).isGreaterThanOrEqualTo(0);
    }
}
