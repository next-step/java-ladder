package nextstep.refactoring.ladder.concrete.dto;

import nextstep.refactoring.ladder.concrete.Direction;
import nextstep.refactoring.ladder.concrete.LadderLine;
import nextstep.refactoring.ladder.concrete.Point;
import nextstep.refactoring.ladder.engine.Line;
import nextstep.refactoring.ladder.engine.dto.LineDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineDtoImplTest {

    @Test
    @DisplayName("라인의 각 지점에 대해 우측 지점과의 연결성을 리스트로 반환한다. 마지막 지점은 확인하지 않는다.")
    void getListOfConnectionsAtRightPoint() {
        Point first = Point.of(0, Direction.right());
        Point second = first.next();
        Point third = Point.of(2, Direction.straight());

        Line line = LadderLine.of(first, second, third);

        LineDto lineDto = line.export();

        assertThat(lineDto.connectionList()).containsExactly(true, false);
    }
    
}
