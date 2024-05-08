package nextstep.version.refactor.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    int size;
    int height;
    LineCreator lineCreator;
    Line line;

    @BeforeEach
    void setUp() {
        size = 4;
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
                return booleanList.toArray(new Boolean[]{});
            }
        };

        line = new Line(size, height, lineCreator);
    }

    @DisplayName("라인 리스트를 만들 수 있다.")
    @Test
    void create() {
        Points points = line.get(0);
        Assertions.assertThat(points.hasLine(0)).isTrue();
    }

    @DisplayName("게임을 실행하면 위치값과 결과값을 가지고 있는 결과객체를 반환한다.")
    @Test
    void play() {
        MatchResult matchResult = line.play();
        MatchResult result = new MatchResult(Map.of(0, 1, 1, 0, 2, 3, 3, 2));
        Assertions.assertThat(matchResult).isEqualTo(result);
    }
}
