package nextstep.ladder.domain.line;

import nextstep.ladder.factory.LineFactory;
import nextstep.ladder.factory.PointFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LineFactoryTest {

    @DisplayName("LineFactory 인스턴스 생성")
    @Test
    public void testConstructor() {
        assertDoesNotThrow(() -> new LineFactory(new PointFactory()));
    }

    @DisplayName("Line 생성")
    @Test
    public void testCreate() {
        Random random = new Random() {
            @Override
            public boolean nextBoolean() {
                return true;
            }
        };

        LineFactory lineFactory = new LineFactory(new PointFactory(random));
        assertThat(lineFactory.create(4))
            .isEqualTo(new Line(List.of(new Point(true), new Point(false), new Point(true))));
    }
}
