package nextstep.ladder.domain.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LinesTest {

    @DisplayName("Lines 인스턴스 만들기")
    @Test
    public void testConstructor() {
        assertDoesNotThrow(() -> new Lines(4, new Height(3), new LineFactory(new PointFactory())));
    }

//    @DisplayName("시뮬레이션 테스트")
//    @Test
//    public void testSimulate() {
//        Random random = new Random() {
//            @Override
//            public boolean nextBoolean() {
//                return true;
//            }
//        };
//
//        LineFactory lineFactory = new LineFactory(new PointFactory(random));
//        Lines lines = new Lines(4, new Height(3), lineFactory);
//        assertThat(lines.simulate()).isEqualTo(new Positions(List.of(1, 0, 3, 2)));
//    }
}
