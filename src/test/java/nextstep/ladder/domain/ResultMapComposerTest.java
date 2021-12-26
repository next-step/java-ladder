package nextstep.ladder.domain;

import java.util.Map;

import nextstep.ladder.engine.Prizes;
import nextstep.ladder.engine.ResultMapComposer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import static nextstep.ladder.domain.IndexTest.ix;
import static nextstep.ladder.domain.LadderPrizeTest.pz;
import static nextstep.ladder.domain.LadderPrizesTest.pzs;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ResultMapComposerTest {
    @Test
    public void compose() {
        Prizes prizes = pzs("pz1", "pz2");
        ResultMapComposer composer = LadderResultMapComposer.of(prizes);
        assertThat(composer.compose()).containsAllEntriesOf(Map.of(pz("pz1"), ix(0), pz("pz2"), ix(1)));
    }

    @ParameterizedTest
    @NullSource
    public void createFailed(Prizes prizes) {
        assertThatIllegalArgumentException().isThrownBy(() -> LadderResultMapComposer.of(prizes));
    }
}
