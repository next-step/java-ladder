package com.ladder.view.formatter;

import com.ladder.model.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.ladder.model.Direction.RIGHT;
import static com.ladder.model.LineTest.ofPoint;
import static com.ladder.view.formatter.LadderFormatter.LADDER_OF_COLUMNS;
import static com.ladder.view.formatter.LadderFormatter.LADDER_OF_LINE;
import static org.assertj.core.api.Assertions.assertThat;

class PointFormatterTest {

    private static final Formatter<Point> formatter = new PointFormatter();

    @DisplayName("우측으로 이동 가능 시 라인을 그린다")
    @Test
    void printLine_success() {
        // given
        Point rightPoint = ofPoint(0, RIGHT);

        // when
        String result = formatter.format(rightPoint);

        // then
        assertThat(result).isEqualTo(LADDER_OF_COLUMNS + LADDER_OF_LINE);
    }
}