package ladder.domain;

import ladder.dto.LineGenerateDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("사다리 결과 위치가 예상 결과 위치와 동일해야합니다.")
    void shouldHasExactResult() {
        int numOfUsers = 2;
        int ladderLength = 2;
        /**
         * 사다리 테스트케이스 모양
         * USER1 USER2
         *  |-----|
         *  |-----|
         */
        Ladder ladder = getLadder(numOfUsers, ladderLength, () -> false);
        List<Position> resultA = ladder.play(List.of(new Position(0)));
        List<Position> resultB = ladder.play(List.of(new Position(1)));

        assertThat(resultA).containsOnly(new Position(0));
        assertThat(resultB).containsOnly(new Position(1));
    }


    private Ladder getLadder(int numberOfUsers, int ladderLength, Supplier<Boolean> lineGenerationPolicy) {
        List<HorizontalLine> horizontalLines = LadderFactory.horizontalLines(new LineGenerateDto(numberOfUsers, ladderLength), new RandomLineGenerator(lineGenerationPolicy));
        List<VerticalLine> verticalLines = LadderFactory.verticalLines(horizontalLines, numberOfUsers);
        return new Ladder(verticalLines, new LadderLength(ladderLength));
    }

}
