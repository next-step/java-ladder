package step1.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

class PositionTest {

    @Test
    @DisplayName("Position이 아래로 이동할 때 입력된 줄 정보에 맞게 이동하는지 검증")
    void moveDown() {
        Lines lines = Lines.from(List.of(
            Line.from(List.of(new Bridge(false), new Bridge(false))),
            Line.from(List.of(new Bridge(true), new Bridge(false)))
        ));

        // 왼쪽 이동
        then(new Position(1).moveDown(lines, 1)).isEqualTo(new Position(0));

        // 오른쪽 이동
        then(new Position(0).moveDown(lines, 1)).isEqualTo(new Position(1));
    }
}