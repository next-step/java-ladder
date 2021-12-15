package nextstep.ladder.domain;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static nextstep.ladder.domain.PlayerTest.p;
import static nextstep.ladder.domain.ResultTest.r;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ResultOfGameTest {
    @Test
    public void create() {
        Map<Player, Result> resultMap = Map.of(p("p1"), r("r1"), p("p2"), r("r2"));
        assertThat(ResultOfGame.of(resultMap)).isEqualTo(ResultOfGame.of(resultMap));
    }

    static Stream<Arguments> parseCreateFailed() {
        return Stream.of(
                Arguments.of(Map.of(p("p1"), r("r1")))
        );
    }

    @ParameterizedTest(name = "create failed: {arguments}")
    @NullAndEmptySource
    @MethodSource("parseCreateFailed")
    public void createFailed(Map<Player, Result> playerResultMap) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ResultOfGame.of(playerResultMap))
                .withMessageContaining("invalid input");
    }

    @Test
    public void resultExist() {
        Player p1 = p("p1");
        Result r1 = r("r1");
        Map<Player, Result> resultMap = Map.of(p1, r1, p("p2"), r("r2"));
        assertThat(ResultOfGame.of(resultMap).result(p1).isPresent()).isTrue();
        assertThat(ResultOfGame.of(resultMap).result(p1)).isEqualTo(Optional.of(r1));
    }

    @Test
    public void resultNotExist() {
        Map<Player, Result> resultMap = Map.of(p("p1"), r("r1"), p("p2"), r("r2"));
        assertThat(ResultOfGame.of(resultMap).result(p("p3")).isPresent()).isFalse();
        assertThat(ResultOfGame.of(resultMap).result(p("p3"))).isEqualTo(Optional.empty());
    }

    @Test
    public void stream() {
        Map<Player, Result> resultMap = Map.of(p("p1"), r("r1"), p("p2"), r("r2"));
        assertThat(ResultOfGame.of(resultMap).streamOfEntry()).hasSameElementsAs(resultMap.entrySet());
    }
}
