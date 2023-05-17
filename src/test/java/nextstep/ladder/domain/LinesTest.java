package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    private Lines lines = new Lines();

    @BeforeEach
    void setUp() {
        lines.addLine(new Line(new Position(0, 0), new Position(1, 0)));
    }

    @DisplayName("Lines 클래스에 Line 클래스에 Position이 겹칠경우 addLine을 호출하더라도 Line이 추가되면 안된다.")
    @Test
    void 중복_라인_검증() {
        lines.addLine(new Line(new Position(1, 0), new Position(2, 0)));
        assertThat(lines.hasLine(new Line(new Position(1, 0), new Position(2, 0)))).isFalse();
    }

    @DisplayName("Lines 클래스에 Line 클래스에 Position이 겹치지 않을 경우 addLine 호출시 Line이 추가되야 한다.")
    @Test
    void 라인_추가_결과_검증() {
        lines.addLine(new Line(new Position(2, 0), new Position(3, 0)));
        assertThat(lines.hasLine(new Line(new Position(2, 0), new Position(3, 0)))).isTrue();
    }


}