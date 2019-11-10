package nextstep.ladder;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LaddersTest {
    private Ladders ladders;
    private List<Point> pointList;

    @BeforeEach
    void setUp() {
        List<Ladder> ladderList = new ArrayList<>();
        pointList = Lists.newArrayList(new Point(Direction.LEFT), new Point(Direction.RIGHT), new Point(Direction.LEFT));
        ladderList.add(new Ladder(pointList));
        ladders = new Ladders(ladderList);
    }

    @Test
    @DisplayName("add 메소드 호출시 ladder가 추가 되는지 확인 한다.")
    void add() {
        Ladders ladders = new Ladders();
        ladders.add();

        assertThat(ladders.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("ladder의 height가 올라가는지 확인한다.")
    void addHeight() {
        int expectedHeight = pointList.size() + 1;

        assertThat(ladders.height()).isEqualTo(pointList.size());

        ladders.addHeight(0, Direction.LEFT);

        assertThat(ladders.height()).isEqualTo(expectedHeight);
    }

    @Test
    @DisplayName("ladder index 와 height를 전달해 Direction을 얻어 오는지 확인 한다.")
    void ladderDirection() {
        assertThat(ladders.ladderDirection(0, 1)).isEqualTo(Direction.RIGHT);
    }
}
