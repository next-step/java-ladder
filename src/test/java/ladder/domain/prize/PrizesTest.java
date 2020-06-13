package ladder.domain.prize;

import ladder.domain.ladder.Position;
import ladder.fixture.PlayerAndPrizeFixtures;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PrizesTest {

    private final static List<String> names = PlayerAndPrizeFixtures.prizeNames;

    @DisplayName("null 이거나 0개의 이름이 입력되면 예외를 반환")
    @NullAndEmptySource
    @ParameterizedTest
    void createFailure(final List<String> names) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Prizes.of(names));
    }

    @DisplayName("이름 리스트로부터 여러 개의 Prize 생성")
    @Test
    void create() {
        assertThat(Prizes.of(names).count())
                .isEqualTo(names.size());
    }

    @DisplayName("Prizes 의 모든 이름을 반환")
    @Test
    void getNames() {
        assertThat(Prizes.of(names).getNames())
                .isEqualTo(names);
    }

    @DisplayName("배열 순서에 해당하는 Prize 를 반환")
    @ParameterizedTest
    @MethodSource
    void indexOf(final Position index, final Prize expected) {
        assertThat(Prizes.of(names).indexOf(index))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> indexOf() {
        return Stream.of(
                Arguments.of(Position.of(0), Prize.of("꽝")),
                Arguments.of(Position.of(1), Prize.of("5000"))
        );
    }
}
