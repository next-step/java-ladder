package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;

public class LineTest {

    @MethodSource("사다리_위치_리스트_생성")
    @ParameterizedTest
    @DisplayName("라인 생성 테스트 추가")
    void create(List<Position> positions) {
        assertThatCode(() -> new Line(positions));
    }

    private static Stream<Arguments> 사다리_위치_리스트_생성() {
        List<Position> positions = new ArrayList<>();
        positions.add(new Position(0, Direction.LEFT));
        positions.add(new Position(1, Direction.DOWN));

        return Stream.of(Arguments.of(positions));
    }
}
