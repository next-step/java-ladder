package nextstep.version.refactor.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {


    @DisplayName("라인 리스트를 만들 수 있다.")
    @Test
    void create() {
        int size = 4;
        int height = 5;

        LineCreator lineCreator = new LineCreator() {
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

        Line line = new Line(size, height, lineCreator);
        Points points = line.get(0);
        Assertions.assertThat(points.hasLine(0)).isTrue();
    }
}
