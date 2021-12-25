package nextstep.ladder.domain;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import nextstep.ladder.engine.Name;
import nextstep.ladder.engine.Prize;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static nextstep.ladder.domain.LadderPrizeTest.pz;
import static nextstep.ladder.domain.PlayerNameTest.pn;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderGameResultTest {
    @Test
    public void create() {
        Map<Name, Prize> resultMap = Map.of(pn("p1"), pz("r1"), pn("p2"), pz("r2"));
        assertThat(LadderGameResult.of(resultMap)).isEqualTo(LadderGameResult.of(resultMap));
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
                .isThrownBy(() -> LadderGameResult.of(playerResultMap));
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
