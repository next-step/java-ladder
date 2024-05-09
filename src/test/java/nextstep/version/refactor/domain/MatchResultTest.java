package nextstep.version.refactor.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MatchResultTest {
    int size;
    int height;
    LineCreator lineCreator;
    Line line;

    @BeforeEach
    void setUp() {
        size = 3;
        height = 5;
        lineCreator = new LineCreator() {
            @Override
            public Boolean[] createBooleanList(int size) {
                List<Boolean> booleanList = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    if (i == 0) {
                        booleanList.add(true);
                        continue;
                    }
                    booleanList.add(!booleanList.get(i - 1));
                }
                Boolean[] array = booleanList.toArray(new Boolean[]{});
                return array;
            }
        };

        line = new Line(size, height, lineCreator);
    }

    @DisplayName("참가자와 상품을 받아서 매칭시켜준다.")
    @Test
    void map() {
        Participants participants = new Participants("pobi,teddy,nana");
        Rewards rewards = new Rewards("꽝,1등,꽝");
        MatchResult matchResult = new MatchResult(Map.of(0, 1, 1, 0, 2, 2));
        LadderResult ladderResult = matchResult.map(participants, rewards);
        assertThat(ladderResult).isEqualTo(new LadderResult(Map.of("pobi", "1등", "teddy", "꽝", "nana", "꽝")));
    }
}
