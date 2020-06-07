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
        assertThatCode(() -> new Ladder(positions, Height.of(5))).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("사다리 생성 에외 테스트 - 위치 리스트가 2보다 작으면 예외가 발생한다.")
    void exception() {
        List<Position> positions = Arrays.asList(new Position(0, Height.of(0), Direction.LEFT));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ladder(positions, Height.of(1)));
    }

}
