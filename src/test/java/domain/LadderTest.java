package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    public void 사용자수x높이의_사다리를_생성한다() {
        List<User> users = Arrays.asList(
            new User("user1"), new User("user2"), new User("user3"));
        Ladder ladder = new Ladder(users.size(), 5);

        assertThat(ladder.getLines()).hasSize(5);
        assertThat(ladder.getLines().get(0).getPoints()).hasSize(3);
    }

    /*
    @Test
    public void 전달받은_포인트에_라인_추가가_가능하면_라인을_추가한다() {
        Ladder ladder = new Ladder(Point.valuesOf(5, 6), Arrays.asList(Point.valueOf(1, 1), Point.valueOf(2, 1)));
        assertThat(ladder.getLines()).hasSize(1);
    }

    @Test
    public void 시작점을_넣으면_끝점을_찾는다() {
        Ladder ladder = new Ladder(Point.valuesOf(5, 6), Collections.emptyList());
        Point point = ladder.findLast(Point.valueOf(1, 1));
        assertThat(point).isEqualTo(Point.valueOf(1, 6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 시작점이_아니면_예외가_발생한다() {
        Ladder ladder = new Ladder(Point.valuesOf(5, 6), Collections.emptyList());
        ladder.findLast(Point.valueOf(1, 2));
    }

    @Test
    public void 넓이_높이를_반환한다() {
        Ladder ladder = new Ladder(Point.valuesOf(5, 6), Collections.emptyList());
        assertThat(ladder.getWidth()).isEqualTo(5);
        assertThat(ladder.getHeight()).isEqualTo(6);
    }
    */
}
