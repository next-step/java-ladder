package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static nextstep.ladder.TestUtil.asPointList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LadderFactoryTest {

    @Test
    @DisplayName("랜덤 Ladder 생성")
    void generate() {
        // given
        int height = 5;
        int countOfPerson = 4;

        // when
        Ladder actual = LadderFactory.generate(height, countOfPerson, new RandomPointGenerator());

        // then
        assertNotNull(actual);
    }

    @Test
    @DisplayName("연결되지 않은 Ladder 생성")
    void generate_noConnection() {
        int height = 5;
        int countOfPerson = 4;

        Ladder actual = LadderFactory.generate(height, countOfPerson, () -> Point.of(false));
        Ladder expected = Ladder.of(height, countOfPerson,
                Line.of(asPointList(false, false, false)),
                Line.of(asPointList(false, false, false)),
                Line.of(asPointList(false, false, false)),
                Line.of(asPointList(false, false, false)),
                Line.of(asPointList(false, false, false))
        );

        assertEquals(expected, actual);
    }
}
