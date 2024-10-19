package nextstep.ladder;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Line;
import nextstep.ladder.model.LineGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LadderTest {
    @Test
    @DisplayName("ladder 생성 테스트")
    void createLadderTest(){
        //given
        final int countOfPlayers = 4;
        final int height = 5;
        final LineGenerator lineGenerator = new MockLineGenerator();


        //when
        Ladder ladder = new Ladder(countOfPlayers, height, lineGenerator);

        //then
        Assertions.assertThat(ladder).isNotNull();
        Assertions.assertThat(ladder.getHeight()).isEqualTo(height);

        List<Line> lines = ladder.getLines();
        Assertions.assertThat(lines.get(0).getPoints()).hasSize(countOfPlayers-1);
        System.out.println(lines);
    }
}
