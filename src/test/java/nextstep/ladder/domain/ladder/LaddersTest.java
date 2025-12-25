package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.*;

public class LaddersTest {


    @Test
    void 사다리_임의_생성(){
        TreeMap<Ladder, Boolean> ladderMap = new TreeMap<>();
        ladderMap.put(new Ladder(0, 0), true);
        ladderMap.put(new Ladder(0, 1), false);
        ladderMap.put(new Ladder(1, 0), false);
        ladderMap.put(new Ladder(1, 1), true);
        Ladders ladders = new Ladders(ladderMap, 2);

        assertThat(ladders.getLadders()).hasSize(4);
        assertThat(ladders.getHeight()).isEqualTo(new Height(2));
    }

    @Test
    void 사다리_전체_랜덤_생성() {
        Ladders ladders = new Ladders(3, 3);
        assertThat(ladders.getLadders()).hasSize(9);
        assertThat(ladders.getHeight()).isEqualTo(new Height(3));
    }

}
