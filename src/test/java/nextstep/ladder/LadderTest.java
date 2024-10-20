package nextstep.ladder;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Line;
import nextstep.ladder.model.LineGenerator;
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
        int height = 5;
        LineGenerator lineGenerator = new MockLineGenerator();


        //when
        Ladder ladder = new Ladder(
                IntStream.range(0, height)
                        .mapToObj(it -> new Line(countOfPlayers, lineGenerator))
                        .collect(Collectors.toList())
        );

        //then
        Assertions.assertThat(ladder).isNotNull();
        Assertions.assertThat(ladder.getLines().size()).isEqualTo(height);

        List<Line> lines = ladder.getLines();
        Assertions.assertThat(lines.get(0).getPoints()).hasSize(countOfPlayers - 1);
        System.out.println(lines);
    }
}
