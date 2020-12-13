package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    private List<Point> lineConnections = new ArrayList<>();

    @BeforeEach
    public void init(){
        lineConnections.add(new Point(0, Direction.of(false,true)));
    }

    @DisplayName("Ladder 생성 테스트")
    @Test
    void ladderConstructorTest(){
        // given
        List<Line> lines = new ArrayList<>();
        lines.add(new Line(lineConnections));

        // when
        Ladder ladder = new Ladder(lines);

        // then
        assertThat(ladder.getLines().get(0)).isEqualTo(new Line(lineConnections));
    }

    @DisplayName("Ladder move 테스트")
    @Test
    void ladderMoveTest(){
        // given
        List<Line> lines = new ArrayList<>();
        lines.add(new Line(lineConnections));

        // when
        Ladder ladder = new Ladder(lines);

        // then
        assertThat(ladder.climb(0)).isEqualTo(1);
    }

}
