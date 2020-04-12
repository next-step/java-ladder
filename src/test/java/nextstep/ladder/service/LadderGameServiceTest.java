package nextstep.ladder.service;

import nextstep.ladder.domain.gamer.Gamers;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.result.Results;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderGameServiceTest {
    private static final Gamers gamers = Gamers.of(Arrays.asList("pobi", "test", "test2"));
    private static final Ladder ladder = Ladder.of(3, 1);
    private static final Results results = Results.of(Arrays.asList("boom", "2000", "50000"));

    @Test
    void of() {
        LadderGameService ladderGameService = LadderGameService.of(gamers, results, ladder);
        System.out.println(ladderGameService);
    }

    @Test
    void ofException() {
        assertThatThrownBy(() -> LadderGameService.of(gamers, results, Ladder.of(4, 1)));
        assertThatThrownBy(() -> LadderGameService.of(gamers, Results.of(Arrays.asList("1", "2")), ladder));
        assertThatThrownBy(() -> LadderGameService.of(Gamers.of(Arrays.asList("pobi", "test")), results, ladder));
    }

    @Test
    void getResult() {
        LadderGameService ladderGameService = LadderGameService.of(gamers, results, ladder);
        System.out.println(ladderGameService.getResult("pobi"));
    }

}