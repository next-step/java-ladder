package nextstep.ladder.domain;

import nextstep.ladder.vo.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    private Line ALL_FALSE_LINE;
    private List<Line> ALL_FALSE_LINE_LIST;
    private List<Person> people;
    private LadderGame ladderGame;
    private List<Winner> WINNER_IMPLS;

    @BeforeEach
    void setUp() {
        ALL_FALSE_LINE = new Line(List.of(false, false, false, false));
        ALL_FALSE_LINE_LIST = List.of(ALL_FALSE_LINE, ALL_FALSE_LINE, ALL_FALSE_LINE, ALL_FALSE_LINE, ALL_FALSE_LINE);
        WINNER_IMPLS = List.of(new Winner(new Person("pobi"), "꽝"), new Winner(new Person("honux"), "5000"), new Winner(new Person("crong"), "꽝"), new Winner(new Person("jk"), "3000"));
        people = List.of(new Person("pobi"), new Person("honux"), new Person("crong"), new Person("jk"));
        ladderGame = new LadderGame((countOfPerson) -> ALL_FALSE_LINE);
    }

    @Test
    @DisplayName("사다리게임 결과")
    void play() {
        Result result = ladderGame.play("pobi,honux,crong,jk", "꽝,5000,꽝,3000", 5);

        assertThat(result.getPersons()).isEqualTo(people);
        assertThat(result.getLines()).isEqualTo(ALL_FALSE_LINE_LIST);
        assertThat(result.getWinners()).isEqualTo(WINNER_IMPLS);
    }
}
