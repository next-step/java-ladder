package ladder.domain;

import ladder.domain.element.*;
import ladder.domain.line.DrawStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderGameTest {

    private final DrawStrategy testStrategy = (index, indexConsumer) -> indexConsumer.accept(index);

    @Test
    @DisplayName("사람 수와 결과 수 불일치 예외 발생")
    void testPersonAndPrizeSizeIsEqual() {
        // given
        Persons persons = Persons.fromText("a,b,c");
        Ladder ladder = new Ladder(persons, 2, testStrategy);
        Prizes prizes = Prizes.fromText("1,2");

        assertThatThrownBy(() -> new LadderGame(persons, ladder, prizes)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("전체 결과 추출")
    void testGetAllResult() {
        // given
        Persons persons = Persons.fromText("a,b");
        Prizes prizes = Prizes.fromText("1,2");
        Map<String, String> prizeMap = new HashMap<>();
        prizeMap.put("a", "2");
        prizeMap.put("b", "1");

        Ladder ladder = new Ladder(persons, 1, (index, indexConsumer) -> indexConsumer.accept(index));
        LadderGame ladderGame = new LadderGame(persons, ladder, prizes);
        // when
        LadderPrizes ladderPrizes = ladderGame.getAllResult();
        // then
        for (LadderPrize ladderPrize : ladderPrizes) {
            Person person = ladderPrize.getPerson();
            assertThat(ladderPrize.getPrize().getName()).isEqualTo(prizeMap.get(person.getName()));
        }
    }

    @Test
    @DisplayName("특정 사람 결과 추출")
    void testGetResult() {
        // given
        Persons persons = Persons.fromText("a,b");
        Prizes prizes = Prizes.fromText("1,2");
        Ladder ladder = new Ladder(persons, 1, (index, indexConsumer) -> indexConsumer.accept(index));
        LadderGame ladderGame = new LadderGame(persons, ladder, prizes);
        // when
        Prize prize = ladderGame.getResult("a");
        // then
        assertThat(prize).isEqualTo(prizes.get(1));
    }
}
