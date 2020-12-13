package nextstep.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    @DisplayName("라인 생성 테스트")
    void initLine() {
        int numberOfUsers = 3;
        Line line = Line.init(numberOfUsers);

        assertThat(line.getIndexList().size()).isEqualTo(numberOfUsers);
    }

    @Test
    @DisplayName("라인 이동 테스트")
    void moveLine() {
        int position = 0;
        List<Index> indexList = new ArrayList<>();
        // |-| |
        Point point1 = Point.setFirst(previous -> true);
        Index index1 = Index.of(0, point1);
        Index index2 = Index.of(1, point1.setNext(previous -> false));
        Index index3 = Index.of(2, point1.setLast());

        indexList.add(index1);
        indexList.add(index2);
        indexList.add(index3);

        Line line = Line.from(indexList);

        assertThat(line.move(position)).isEqualTo(1);
    }

}