package nextstep.ladders.domain;

import nextstep.ladders.domain.exceptions.CountOfPersonZeroException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LineTest {

    @Test
    void 라인생성시_사람수가_0명이면_오류() {
        final int countOfPerson = 0;
        assertThrows(CountOfPersonZeroException.class, () -> new Line(countOfPerson, previous -> true));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 라인생성시_사람수만큼_포인트_개수가_존재하는지_검증(final int countOfPerson) {
        Line line = new Line(countOfPerson, previous -> true);
        List<Boolean> points = line.getPoints();
        assertEquals(points.size(), countOfPerson);
    }

    @Test
    void 라인의_첫번째_포인트_값은_false_이다() {
        Line line = new Line(5, previous -> true);
        List<Boolean> points = line.getPoints();
        assertEquals(points.get(0), false);
    }

    @Test
    void 라인_포인트_값_검증() {
        Line line = new Line(5, previous -> true);
        List<Boolean> points = line.getPoints();
        assertEquals(points.get(0), false);
        points.subList(1, points.size()).forEach(point -> assertEquals(point, true));
    }
}