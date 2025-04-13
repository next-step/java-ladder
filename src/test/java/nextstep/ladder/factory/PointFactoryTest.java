package nextstep.ladder.factory;

import nextstep.ladder.domain.line.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PointFactoryTest {

    @DisplayName("PointFactory 인스턴스 생성")
    @Test
    public void testConstructor() {
        assertDoesNotThrow(() -> new PointFactory(new Random()));
    }

    @DisplayName("Point 생성")
    @Test
    public void testCreate() {
        Random random = new Random() {
            @Override
            public boolean nextBoolean() {
                return true;
            }
        };

        PointFactory pointFactory = new PointFactory(random);
        assertThat(pointFactory.create(new Point(false))).isEqualTo(new Point(true));
        assertThat(pointFactory.create(new Point(true))).isEqualTo(new Point(false));
    }
}
