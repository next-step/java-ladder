package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @DisplayName("{countOfPerson}명이 참여하는 {height} 높이의 사다리를 생성한다.")
    @Test
    public void generateLinesTest() {
        final int countOfPerson = 5;
        final int height = 3;
        Ladder ladder = new Ladder(countOfPerson, height);
        List<Line> lineList = ladder.getLines();

        assertThat(lineList).hasSize(height);
    }

    @DisplayName("사다리 타기 결과로 알맞은 index를 반환한다.")
    @Test
    public void testLines() {
        // 테스트 케이스 사다리 모양
//        |-----|     |-----|
//        |     |-----|     |
//        |-----|     |     |
//        |     |-----|     |
//        |-----|     |-----|
        Ladder ladder = new Ladder(List.of(
                new Line(List.of(true, false, true)),
                new Line(List.of(false, true, false)),
                new Line(List.of(true, false, false)),
                new Line(List.of(false, true, false)),
                new Line(List.of(true, false, true))));

        assertThat(ladder.findResultIndexBy(0)).isEqualTo(0);
        assertThat(ladder.findResultIndexBy(1)).isEqualTo(3);
        assertThat(ladder.findResultIndexBy(2)).isEqualTo(2);
        assertThat(ladder.findResultIndexBy(3)).isEqualTo(1);
    }
}
