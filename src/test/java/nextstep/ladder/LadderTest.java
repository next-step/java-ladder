package nextstep.ladder;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Line;
import nextstep.ladder.model.LineGenerator;
import nextstep.ladder.model.Point;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderTest {
    @Test
    @DisplayName("ladder 생성 테스트")
    void createLadderTest() {
        //given
        int countOfPlayers = 4;
        int height = 1;
        LineGenerator lineGenerator = new MockLineGenerator();


        //when
        Ladder ladder = new Ladder(
                IntStream.range(0, height)
                        .mapToObj(it -> new Line(countOfPlayers, lineGenerator))
                        .collect(Collectors.toList())
        );

        //then
        Assertions.assertThat(ladder).isNotNull();


        Ladder expectedLadder = new Ladder(
                List.of(new Line(List.of(
                        new Point(true),
                        new Point(false),
                        new Point(true)
                )))
        );

        Assertions.assertThat(ladder).isEqualTo(expectedLadder);
    }
}
