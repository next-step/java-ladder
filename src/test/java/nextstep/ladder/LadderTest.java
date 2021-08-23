package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    @DisplayName("라인 생성 테스트")
    void lineTest() {
        Ladder ladderLine = Ladder.of(2, () -> true);
        assertThat(ladderLine.getLines().get(0)).isEqualTo(true);
        assertThat(ladderLine.getLines().get(1)).isEqualTo(false);
    }

    @Test
    @DisplayName("라인 불리언 출력 테스트")
    void printLineTest() {
        StringBuffer sb = new StringBuffer();

        System.out.println(sb);
        Ladder ladder = Ladder.of(3, () -> true);
        assertThat(ladder.getLines()).extracting(line -> line).contains(true,false);

    }

    @Test
    @DisplayName("출발점 입력시 포인트 이동 테스트")
    void ladderResultTest() {
        StringBuffer sb = new StringBuffer();

        System.out.println(sb);
        Ladder ladder = Ladder.of(4, () -> true);
        System.out.println(ladder.getLines().toString());
        assertThat(ladder.movePoint(0)).isEqualTo(1);
        assertThat(ladder.movePoint(1)).isEqualTo(0);
        assertThat(ladder.movePoint(2)).isEqualTo(3);
        assertThat(ladder.movePoint(3)).isEqualTo(2);
    }
}
