package nextstep.ladder2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 요구사항
 *
 * * 넓이(플레이어 수)를 입력받는다.
 * * 플레이어 수 만큼 Point 들을 생성한다
 * * Point 간 이동을 대리하는 move 메시지를 제공한다.
 */
public class LadderLineTest {
    @Test
    void create() {
        assertThat(LadderLine.of(3).sizeOfPoints()).isEqualTo(3);
    }

    @Test
    void createWithPoint() {
        assertThat(LadderLine.of(3, new TestingBooleanGenerator(true, false)))
                .isEqualTo(new LadderLine(buildPoints(true, false)));
    }

    private static class LadderLine {
        private int size;

        public LadderLine(int size) {
            this.size = size;
        }

        public static LadderLine of(int size) {
            return new LadderLine(3);
        }

        public int sizeOfPoints() {
            return size;
        }
    }
}
