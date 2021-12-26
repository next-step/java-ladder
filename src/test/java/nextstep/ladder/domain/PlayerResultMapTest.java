package nextstep.ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import nextstep.ladder.engine.Name;
import nextstep.ladder.engine.Players;
import nextstep.ladder.engine.Prize;
import nextstep.ladder.engine.Prizes;
import nextstep.ladder.engine.ResultMap;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import static nextstep.ladder.domain.LadderPlayersTest.ps;
import static nextstep.ladder.domain.LadderPrizeTest.pz;
import static nextstep.ladder.domain.LadderPrizesTest.pzs;
import static nextstep.ladder.domain.PlayerNameTest.pn;
import static nextstep.ladder.domain.LadderLineTest.simpleLine;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayerResultMapTest {
    @Test
    public void creat() {
        assertThat(PlayerResultMap.of(pzs("pz1", "pz2"))).isExactlyInstanceOf(PlayerResultMap.class);
    }

    @ParameterizedTest(name = "create failed: {arguments}")
    @NullSource
    public void craeteFailed(Prizes prizes) {
        assertThatIllegalArgumentException().isThrownBy(() -> PlayerResultMap.of(prizes));
    }

    @Test
    public void result() {
        ResultMap resultMap = PlayerResultMap.of(pzs("pz1", "pz2"));
        Map<Name, Prize> expected = Map.of(pn("p1"), pz("pz1"), pn("p2"), pz("pz2"));
        assertThat(resultMap.result(ps("p1", "p2"))).isEqualTo(LadderGameResult.of(expected));
    }

    static Stream<Arguments> parseResultFailed() {
        return Stream.of(
                Arguments.of(ps("p1", "p2", "p3"))
        );
    }

    @ParameterizedTest(name = "result failed")
    @NullSource
    @MethodSource("parseResultFailed")
    public void resultFailed(Players players) {
        ResultMap resultMap = PlayerResultMap.of(pzs("pz1", "pz2"));
        assertThatIllegalArgumentException().isThrownBy(() -> resultMap.result(players));

    }

    @Test
    public void move() {
        ResultMap resultMap = PlayerResultMap.of(pzs("pz1", "pz2"));
        Map<Name, Prize> expected = Map.of(pn("p1"), pz("pz2"), pn("p2"), pz("pz1"));
        resultMap.move(List.of(simpleLine()));
        assertThat(resultMap.result(ps("p1", "p2"))).isEqualTo(LadderGameResult.of(expected));
    }
}
