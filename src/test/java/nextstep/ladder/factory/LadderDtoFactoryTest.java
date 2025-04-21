package nextstep.ladder.factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LadderDtoFactoryTest {

    @DisplayName("LadderFactory 인스턴스 생성")
    @Test
    public void testConstructor() {
        assertDoesNotThrow(LadderDtoFactory::new);
    }
}
