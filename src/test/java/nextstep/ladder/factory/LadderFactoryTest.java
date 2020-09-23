package nextstep.ladder.factory;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import nextstep.ladder.pattern.RandomPointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static nextstep.ladder.TestUtil.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LadderFactoryTest {

    private final int height = 5;
    private final int countOfPerson = 4;

    @Test
    @DisplayName("랜덤 Ladder 생성")
    void generate() {
        Ladder actual = LadderFactory.generate(height, countOfPerson, new RandomPointGenerator());
        assertNotNull(actual);
    }

    @Test
    @DisplayName("연결되지 않은 Ladder 생성")
    void generate_noConnection() {
        // when
        Ladder actual = LadderFactory.generate(height, countOfPerson, () -> Point.of(false));

        // then
        List<Line> lines = Arrays.asList(
                asLine(false, false, false),
                asLine(false, false, false),
                asLine(false, false, false),
                asLine(false, false, false),
                asLine(false, false, false)
        );
        Ladder expected = Ladder.of(height, countOfPerson, lines);

        assertEquals(expected, actual);
    }
}
