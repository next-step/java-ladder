package nextstep.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("사다리 생성 테스트")
    void initLadder() {
        int numberOfUsers = 3;
        int height = 5;
        Ladder ladder = Ladder.init(3, 5);
        assertThat(ladder.getLines().size()).isEqualTo(height);
        assertThat(ladder.getLines().get(0).getIndexList().size()).isEqualTo(numberOfUsers);
    }

    @Test
    @DisplayName("사다리 이동 테스트")
    void moveLadder() {
        int position = 0;
        // |-| |
        // | |-|
        Point point1 = Point.setFirst(previous -> true);
        Index index1 = Index.of(0, point1);
        Index index2 = Index.of(1, point1.setNext(previous -> false));
        Index index3 = Index.of(2, point1.setLast());
        Line line1 = new Line(Arrays.asList(index1, index2, index3));

        Point point2 = Point.setFirst(previous -> false);
        Index index4 = Index.of(0, point2);
        Index index5 = Index.of(1, point2.setNext(previous -> true));
        Index index6 = Index.of(2, point2.setLast());
        Line line2 = new Line(Arrays.asList(index4, index5, index6));

        Ladder ladder = new Ladder(Arrays.asList(line1, line2));

        assertThat(ladder.move(position)).isEqualTo(2);
    }

}