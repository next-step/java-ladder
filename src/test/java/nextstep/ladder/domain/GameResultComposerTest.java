package nextstep.ladder.domain;

import java.util.Map;
import java.util.stream.Stream;

import nextstep.ladder.engine.GameResultComposer;
import nextstep.ladder.engine.Players;
import nextstep.ladder.engine.Prize;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static nextstep.ladder.domain.IndexTest.ix;
import static nextstep.ladder.domain.LadderPlayersTest.ps;
import static nextstep.ladder.domain.LadderPrizeTest.pz;
import static nextstep.ladder.domain.PlayerNameTest.pn;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class GameResultComposerTest {
    @Test
    public void compose() {
        Players players = ps("p1", "p2");
        Map<Prize, Index> resultIndexMap = Map.of(pz("pz1"), ix(1), pz("pz2"), ix(0));
        GameResultComposer composer = LadderGameResultComposer.of(players, resultIndexMap);
        assertThat(composer.compose()).containsAllEntriesOf(Map.of(pn("p1"), pz("pz2"), pn("p2"), pz("pz1")));
    }

    static Stream<Arguments> parseCreateFailed() {
        return Stream.of(
                Arguments.of(null, Map.of(pz("pz1"), ix(1), pz("pz2"), ix(0))),
                Arguments.of(ps("p1", "p2"), null),
                Arguments.of(ps("p1", "p2", "p3"), Map.of(pz("pz1"), ix(1), pz("pz2"), ix(0)))
        );
    }

    @ParameterizedTest
    @MethodSource("parseCreateFailed")
    public void createFailed(Players players, Map<Prize, Index> resultIndexMap) {
        assertThatIllegalArgumentException().isThrownBy(() -> LadderGameResultComposer.of(players, resultIndexMap));
    }
}
