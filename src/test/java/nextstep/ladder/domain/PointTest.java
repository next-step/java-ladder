package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class PointTest {

    @Test
    void 다리_포인트가_존재하는_경우_스왑된다() {
        Point point = new Point(true, 0);

        HashMap<Integer, Integer> map = new HashMap<>(Map.of(0, 0, 1, 1));
        point.move(map);

        assertThat(map).isEqualTo(Map.of(0, 1, 1, 0));
    }

    @Test
    void 다리의_포인트가_없으면_스왑되지않는다() {
        Point point = new Point(false, 0);

        HashMap<Integer, Integer> map = new HashMap<>(Map.of(0, 0, 1, 1));
        point.move(map);

        assertThat(map).isEqualTo(Map.of(0, 0, 1, 1));
    }

}
