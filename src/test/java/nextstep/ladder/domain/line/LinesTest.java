package nextstep.ladder.domain.line;

import nextstep.ladder.domain.user.LadderUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LinesTest {

    @DisplayName("Lines 인스턴스 만들기")
    @Test
    public void testConstructor() {
        assertDoesNotThrow(() -> new Lines(
            new LadderUsers(List.of("pobi", "honux", "crong", "jk")),
            new Height(3),
            new LineFactory(new PointFactory())
        ));
    }
}
