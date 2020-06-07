package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {

    @MethodSource("사다리_위치_리스트_생성")
    @ParameterizedTest
    @DisplayName("사다리 생성 테스트 추가")
    void create(List<Position> positions) {
        assertThatCode(() -> new Ladder(positions)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("사다리 생성 에외 테스트 - 위치 리스트가 2보다 작으면 예외가 발생한다.")
    void exception() {
        List<Position> positions = Arrays.asList(new Position(0, Height.of(0), new Line(Direction.of(Direction.RIGHT))));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ladder(positions));
    }

    private static Stream<Arguments> 사다리_위치_리스트_생성() {
        List<Position> positions = new ArrayList<>();
        positions.add(new Position(0, Height.of(0), new Line(Direction.of(Direction.RIGHT))));
        positions.add(new Position(1, Height.of(0), new Line(Direction.of(Direction.LEFT))));

        return Stream.of(
                Arguments.of(positions));
    }
}
