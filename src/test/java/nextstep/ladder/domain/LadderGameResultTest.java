package nextstep.ladder.domain;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import nextstep.ladder.engine.Name;
import nextstep.ladder.engine.Players;
import nextstep.ladder.engine.Prize;
import nextstep.ladder.engine.Prizes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static nextstep.ladder.domain.LadderPlayersTest.ps;
import static nextstep.ladder.domain.LadderPrizesTest.pzs;
import static nextstep.ladder.domain.PlayerNameTest.pn;
import static nextstep.ladder.domain.LadderPrizeTest.pz;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderGameResultTest {
    @Test
    public void create() {
        Players players = ps("p1", "p2");
        Prizes results = pzs("pz2", "pz1");
        assertThat(LadderGameResult.of(players, results)).isEqualTo(LadderGameResult.of(players, results));
    }

    static Stream<Arguments> parseCreateFailed() {
        return Stream.of(
                Arguments.of(null, pzs("r1", "r2")),
                Arguments.of(ps("p1", "p2"), null)
        );
    }

    @ParameterizedTest(name = "create failed: {arguments}")
    @MethodSource("parseCreateFailed")
    public void createFailed(Players players, Prizes prizes) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderGameResult.of(players, prizes));
    }

    @Test
    public void resultExist() {
        String p1 = "p1";
        String r1 ="r1";
        Map<Name, Prize> resultMap = Map.of(pn(p1), pz(r1), pn("p2"), pz("r2"));
        assertThat(LadderGameResult.of(resultMap).result(p1).isPresent()).isTrue();
        assertThat(LadderGameResult.of(resultMap).result(p1)).isEqualTo(Optional.of(pz(r1)));
    }

    @Test
    public void resultNotExist() {
        Map<Name, Prize> resultMap = Map.of(pn("p1"), pz("r1"), pn("p2"), pz("r2"));
        assertThat(LadderGameResult.of(resultMap).result("p3").isPresent()).isFalse();
        assertThat(LadderGameResult.of(resultMap).result("p3")).isEqualTo(Optional.empty());
    }

    @Test
    public void stream() {
        Map<Name, Prize> resultMap = Map.of(pn("p1"), pz("r1"), pn("p2"), pz("r2"));
        assertThat(LadderGameResult.of(resultMap).stream()).hasSameElementsAs(resultMap.entrySet());
    }
}
