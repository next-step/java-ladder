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
    @DisplayName("라인 문자열 출력 테스트")
    void printLineTest() {
        StringBuffer sb = new StringBuffer();

        System.out.println(sb);
        Ladder ladder = Ladder.of(3, () -> true);
        System.out.println(ladder.getLines());
    }

    @Test
    @DisplayName("출발점 입력시 포인트 이동 테스트")
    void ladderResultTest() {
        StringBuffer sb = new StringBuffer();

        System.out.println(sb);
        Ladder ladder = Ladder.of(4, () -> true);
        System.out.println(ladder.getLines().toString());
        System.out.println(ladder.movePoint(0));
        System.out.println(ladder.movePoint(1));
        System.out.println(ladder.movePoint(2));
        System.out.println(ladder.movePoint(3));
//        assertThat(ladder.movePoint(3)).isEqualTo(2);
    }
}
