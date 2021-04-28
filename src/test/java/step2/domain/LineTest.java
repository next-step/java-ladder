package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LineTest {
    @Test
    @DisplayName("사람인원수 만큼 라인이 그려졌는지 테스트")
    void lineSizeTest() {
        Line line = Line.init(3, new FixedGenerator(true));
        assertThat(line.getLineSize()).isEqualTo(3);
    }

    @Test
    @DisplayName("최소 인원수 테스트")
    void memberMinCountTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Line.init(0, new RandomGenerator()))
                .withMessage("두 명 이상의 사용자가 참여해야 합니다.");
    }

    @Test
    @DisplayName("지정한 위치에서 우측으로 이동하면 index 1 증가")
    void movingLineTest() {
        Line line = Line.init(2, new FixedGenerator(true));

        assertThat(line.move(0)).isEqualTo(1);
    }

    @Test
    @DisplayName("지정한 위치에서 좌측으로 이동하면 index 1감소")
    void movingLeftLineTest(){
        Line line = Line.init(3, new FixedGenerator(true));

        assertThat(line.move(1)).isEqualTo(0);
    }
}
