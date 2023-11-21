package ladder.domain;

import ladder.LadderGame;
import ladder.domain.util.RandomBooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test
    @DisplayName("로또 게임 결과의 집합은 입력된 로또게임 결과의 항목과 모두 일치해야한다.")
    void createLottoGameResult(){
        Names names = new Names(List.of(new Name("ryan"), new Name("jason"), new Name("brown")));
        List<String> prizes = List.of("꽝", "꽝", "3등");
        Ladder ladder = new Ladder(names.names().size()-1, 6, new RandomBooleanGenerator()).makeLadder();
        Map<Name, String> result = LadderGame.playing(names, prizes, ladder);
        assertThat(prizes).containsAll(result.values());
    }
}
