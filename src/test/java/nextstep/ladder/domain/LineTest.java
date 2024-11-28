package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LineTest {

    @Test
    void 다리_포인트가_존재하는_경우_스왑된다() {
        Line line = new Line(true, 0);

        Position position = new Position(List.of(0, 1));
        line.move(position);

        assertThat(position).isEqualTo(new Position(List.of(1, 0)));
    }

    @Test
    void 다리의_포인트가_없으면_스왑되지않는다() {
        Line line = new Line(false, 0);

        Position position = new Position(List.of(0, 1));
        line.move(position);

        assertThat(position).isEqualTo(new Position(List.of(0, 1)));
    }

    @ParameterizedTest
    @MethodSource("connectedTestData")
    void 다리가_연속되었는지_확인한다(LineTesDto dto1, LineTesDto dto2, boolean result) {
        Line line1 = dto1.toEntity();
        Line line2 = dto2.toEntity();
        assertThat(line1.connected(line2)).isEqualTo(result);
    }

    // 테스트에 사용할 데이터 제공하는 메서드
    static Stream<Arguments> connectedTestData() {
        return Stream.of(
                Arguments.of(new LineTesDto(true, 0), new LineTesDto(true, 1), true),
                Arguments.of(new LineTesDto(true, 1), new LineTesDto(true, 0), true),
                Arguments.of(new LineTesDto(true, 0), new LineTesDto(false, 1), false),
                Arguments.of(new LineTesDto(true, 1), new LineTesDto(false, 0), false),
                Arguments.of(new LineTesDto(false, 0), new LineTesDto(false, 1), false),
                Arguments.of(new LineTesDto(true, 0), new LineTesDto(true, 2), false)
        );
    }

    static class LineTesDto {
        boolean hasPoint;
        int left;

        public LineTesDto(boolean hasPoint, int left) {
            this.hasPoint = hasPoint;
            this.left = left;
        }

        Line toEntity() {
            return new Line(hasPoint, left);
        }
    }

}
