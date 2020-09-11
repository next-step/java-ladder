package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    private List names;

    @BeforeEach
    void setUp() {
        names = new ArrayList<GamePerson>();
        names.add(new GamePerson("test1"));
        names.add(new GamePerson("test2"));
        names.add(new GamePerson("test3"));
        names.add(new GamePerson("test4"));
        names.add(new GamePerson("test5"));
    }

    @Test
    @DisplayName("리스트 같은지 체크")
    public void checkList() {
        LadderGame ladderGame = LadderGame.of("test1, test2, test3, test4, test5", 1);
        assertThat(ladderGame.getPeople()).isEqualTo(names);
    }

    @Test
    @DisplayName("Line 사이즈 체크")
    public void checkLines() {
        Ladder ladder = Ladder.of(new LadderHeight(5), 5);
        assertThat(ladder.getLines().size()).isEqualTo(5);
        LadderGame ladderGame = LadderGame.of("test1, test2, test3, test4, test5", 5);
    }
}
