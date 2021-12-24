package nextstep.ladder.domain;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import nextstep.ladder.engine.Name;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static nextstep.ladder.domain.PlayerNameTest.pn;
import static nextstep.ladder.domain.PrizeTest.pz;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ResultOfGameTest {
    @Test
    public void create() {
        Map<Name, Prize> resultMap = Map.of(pn("p1"), pz("r1"), pn("p2"), pz("r2"));
        assertThat(ResultOfGame.of(resultMap)).isEqualTo(ResultOfGame.of(resultMap));
    }

    static Stream<Arguments> parseCreateFailed() {
        return Stream.of(
                Arguments.of(Map.of(pn("p1"), pz("r1")))
        );
    }

    @ParameterizedTest(name = "create failed: {arguments}")
    @NullAndEmptySource
    @MethodSource("parseCreateFailed")
    public void createFailed(Map<Name, Prize> playerResultMap) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ResultOfGame.of(playerResultMap));
    }

    @Test
    public void resultExist() {
        PlayerName p1 = pn("p1");
        Prize r1 = pz("r1");
        Map<Name, Prize> resultMap = Map.of(p1, r1, pn("p2"), pz("r2"));
        assertThat(ResultOfGame.of(resultMap).result(p1).isPresent()).isTrue();
        assertThat(ResultOfGame.of(resultMap).result(p1)).isEqualTo(Optional.of(r1));
    }

    @Test
    public void resultNotExist() {
        Map<Name, Prize> resultMap = Map.of(pn("p1"), pz("r1"), pn("p2"), pz("r2"));
        assertThat(ResultOfGame.of(resultMap).result(pn("p3")).isPresent()).isFalse();
        assertThat(ResultOfGame.of(resultMap).result(pn("p3"))).isEqualTo(Optional.empty());
    }

    @Test
    public void stream() {
        Map<Name, Prize> resultMap = Map.of(pn("p1"), pz("r1"), pn("p2"), pz("r2"));
        assertThat(ResultOfGame.of(resultMap).streamOfEntry()).hasSameElementsAs(resultMap.entrySet());
    }
}
