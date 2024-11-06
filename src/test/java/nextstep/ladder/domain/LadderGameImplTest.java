package nextstep.ladder.domain;

import nextstep.ladder.vo.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameImplTest {
    private LineImpl ALL_FALSE_LINE;
    private List<LineImpl> ALL_FALSE_LINE_LIST;
    private List<PersonImpl> personImpls;
    private nextstep.ladder.engine.LadderGame ladderGame;
    private List<WinnerImpl> WINNER_IMPLS;

    @BeforeEach
    void setUp() {
        ALL_FALSE_LINE = new LineImpl(List.of(false, false, false, false));
        ALL_FALSE_LINE_LIST = List.of(ALL_FALSE_LINE, ALL_FALSE_LINE, ALL_FALSE_LINE, ALL_FALSE_LINE, ALL_FALSE_LINE);
        WINNER_IMPLS = List.of(new WinnerImpl(new PersonImpl("pobi"), "꽝"), new WinnerImpl(new PersonImpl("honux"), "5000"), new WinnerImpl(new PersonImpl("crong"), "꽝"), new WinnerImpl(new PersonImpl("jk"), "3000"));
        personImpls = List.of(new PersonImpl("pobi"), new PersonImpl("honux"), new PersonImpl("crong"), new PersonImpl("jk"));
        ladderGame = new LadderGameImpl((countOfPerson) -> ALL_FALSE_LINE);
    }

    @Test
    @DisplayName("사다리게임 결과")
    void play() {
        Result result = ladderGame.play("pobi,honux,crong,jk", "꽝,5000,꽝,3000", 5);

        assertThat(result.getPersons()).isEqualTo(personImpls);
        assertThat(result.getLines()).isEqualTo(ALL_FALSE_LINE_LIST);
        assertThat(result.getWinners()).isEqualTo(WINNER_IMPLS);
    }
}
