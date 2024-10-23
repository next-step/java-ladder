package laddergame.v2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("사다리를 이동하여 최종 위치를 조회한다")
    @Test
    void move(){
        Line line1 = generateTwoLines(true, false);
        Line line2 = generateTwoLines(false, true);
        Ladder ladder = new Ladder(List.of(line1, line2));
        /*
         위치0   위치1  위치 2
            |-----|     |
            |     |-----|
        */
        assertThat(ladder.move(0)).isEqualTo(2);
        assertThat(ladder.move(1)).isEqualTo(0);
        assertThat(ladder.move(2)).isEqualTo(1);
    }
    
    @DisplayName("사다리 라인을 전부 이동 후, 최종 위치 리스트를 조회한다")
    @Test
    void moveAll(){
        Line line1 = generateTwoLines(true, false);
        Line line2 = generateTwoLines(false, true);
        Ladder ladder = new Ladder(List.of(line1, line2));
        /*
         위치0   위치1  위치 2
            |-----|     |
            |     |-----|
        */
        List<Integer> finalPositions = ladder.moveAll(3);

        assertThat(finalPositions.get(0)).isEqualTo(2);
        assertThat(finalPositions.get(1)).isEqualTo(0);
        assertThat(finalPositions.get(2)).isEqualTo(1);
    }

    private static Line generateTwoLines(boolean firstValue, boolean nextValue) {
        Position first = Position.first(firstValue);
        Position next = first.next(nextValue);
        Position last = next.last();

        return new Line(List.of(first, next, last));
    }

}