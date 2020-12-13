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
        // |-| |
        // | |-|
        Point point1 = Point.setFirst(previous -> true);
        Index index1 = Index.of(0, point1);
        Point point2 = point1.setNext(previous -> false);
        Index index2 = Index.of(1, point2);
        Point point3 = point2.setLast();
        Index index3 = Index.of(2, point3);
        Line line1 = Line.from(Arrays.asList(index1, index2, index3));

        Point point4 = Point.setFirst(previous -> false);
        Index index4 = Index.of(0, point4);
        Point point5 = point4.setNext(previous -> true);
        Index index5 = Index.of(1, point5);
        Point point6 = point5.setLast();
        Index index6 = Index.of(2, point6);
        Line line2 = Line.from(Arrays.asList(index4, index5, index6));

        Ladder ladder = Ladder.from(Arrays.asList(line1, line2));

        assertThat(ladder.move(0)).isEqualTo(2);
        assertThat(ladder.move(1)).isEqualTo(0);
        assertThat(ladder.move(2)).isEqualTo(1);
    }

}