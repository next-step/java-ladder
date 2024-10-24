package nextstep.ladder.domain;

import nextstep.ladder.vo.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    public static final List<Person> PERSONS = List.of(new Person("pobi"), new Person("honux"), new Person("crong"), new Person("jk"));
    public static final Line ALL_FALSE_LINE = new Line(List.of(false, false, false, false));
    public static final List<Line> ALL_FALSE_LINE_LIST = List.of(ALL_FALSE_LINE, ALL_FALSE_LINE, ALL_FALSE_LINE, ALL_FALSE_LINE, ALL_FALSE_LINE);

    private LadderGame ladderGame;

    @BeforeEach
    void setUp() {
        ladderGame = new LadderGame((countOfPerson) -> ALL_FALSE_LINE);
    }

    @Test
    @DisplayName("사다리게임 결과")
    void play() {
        Result result = ladderGame.play("pobi,honux,crong,jk", 5);

        assertThat(result.getPersons()).isEqualTo(PERSONS);
        assertThat(result.getLines()).isEqualTo(ALL_FALSE_LINE_LIST);
    }
}
