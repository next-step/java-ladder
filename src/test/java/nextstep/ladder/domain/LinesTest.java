package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static nextstep.ladder.TestUtil.asPointList;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LinesTest {

    private final int countOfPerson = 4;
    private List<Line> lineList;

    @BeforeEach
    private void setUp() {
        lineList = Arrays.asList(
                asLine(true, false, true),
                asLine(false, true, false),
                asLine(true, false, false),
                asLine(false, true, false),
                asLine(true, false, true)
        );
    }

    @Test
    @DisplayName("팩토리 메소드 정상 작동")
    void of() {
        Lines lines = Lines.of(countOfPerson, lineList);
        assertNotNull(lines);
    }

    @Test
    @DisplayName("팩토리 메소드 예외 발생 - countOfPerson")
    void of_validateSize() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                Lines.of(countOfPerson + 1, lineList)
        );
    }

    private static Line asLine(Boolean... points) {
        return Arrays.stream(points)
                .map(Point::of)
                .collect(collectingAndThen(toList(), Line::of));
    }

    @Test
    @DisplayName("DTO 리스트로 변환")
    void convertToPipes() {
        // given
        Lines lines = Lines.of(countOfPerson, lineList);

        // when
        List<Pipes> actual = lines.convertToPipes();

        // then
        List<Pipes> expected = Arrays.asList(
                asPipes(true, false, true),
                asPipes(false, true, false),
                asPipes(true, false, false),
                asPipes(false, true, false),
                asPipes(true, false, true)
        );
        assertEquals(expected, actual);
    }

    private static Pipes asPipes(Boolean... points) {
        return asPointList(points).stream()
                .map(Pipe::of)
                .collect(collectingAndThen(toList(), Pipes::new));
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi, 0, 0", "honux, 1, 3", "crong, 2, 2", "jk, 3, 1"})
    @DisplayName("각 Line별로 Player의 Lane 이동")
    void move(String name, int startIndex, int endIndex) {
        // given
        Player actual = Player.of(name, Lane.of(startIndex));
        Lines lines = Lines.of(countOfPerson, lineList);

        // when
        lines.move(actual);

        Player expected = Player.of(name, Lane.of(endIndex));
        assertEquals(expected, actual);
    }
}
