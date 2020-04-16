package ladder.domain.line;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {
    @Test
    void createLadderLineTest() {
        int personOfCount = 5;
        Lines ladderLine = new Lines(personOfCount);
        assertThat(ladderLine.showLines().size()).isEqualTo(5);
        System.out.println(ladderLine.showLines());
    }

    @Test
    void moveTest() {
        //|-----|      | 모양 기대 했을 때. -> random() 영향 안 받도록 조정 후 테스트 함.
        Lines lines = new Lines(3);
        assertThat(lines.move(0)).isEqualTo(1);
        assertThat(lines.move(1)).isEqualTo(0);
        assertThat(lines.move(2)).isEqualTo(2);
    }
}
