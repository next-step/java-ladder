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
        lineConnections.add(new Point(true));
        lineConnections.add(new Point(false));
    }

    @DisplayName("Ladder 생성 테스트")
    @Test
    void ladderConstructorTest(){
        // given
        Line line = new Line(lineConnections);

        // when
        Ladder ladder = new Ladder(line);

        // then
        assertThat(ladder.getLine()).isEqualTo(new Line(lineConnections));
    }
}
