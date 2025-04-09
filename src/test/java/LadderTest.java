import domain.Ladder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LadderTest {

    @Test
    void 사다리_생성_및_출력_테스트() {
        // given
        int countOfPerson = 4;
        int height = 5;

        Ladder ladder = new Ladder(countOfPerson, height);
        assertNotNull(ladder);
    }
}