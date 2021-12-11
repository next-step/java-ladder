package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningTest {
    private Names names;
    private List<String> prizes;
    private Ladder ladder;
    private Winning winning;

    @BeforeEach
    public void setup() {
        names = new Names(Arrays.asList("aaa", "bbb", "ccc"));
        prizes = Arrays.asList("1", "2", "3");
        ladder = new Ladder(names, new Height(5));
        winning = ladder.playerByPrize(names, Prizes.of(Arrays.asList("1", "2", "3"), names));
    }

    @Test
    @DisplayName("결과는 참가자 이름만 있다.")
    public void ladderPlayerNames(){
        Assertions.assertAll(
                () -> assertThat(winning.size()).isEqualTo(3),
                () -> assertThat(winning.prize(names.playerName("aaa")).value()).isNotNull(),
                () -> assertThat(winning.prize(names.playerName("bbb")).value()).isNotNull(),
                () -> assertThat(winning.prize(names.playerName("ccc")).value()).isNotNull()
        );
    }


    @Test
    @DisplayName("결과는 입력된 상품만 있다.")
    public void ladderPrize(){
        Assertions.assertAll(
                () -> assertThat(winning.size()).isEqualTo(3),
                () -> assertThat(prizes.contains(winning.prize(names.playerName("aaa")).value())).isTrue(),
                () -> assertThat(prizes.contains(winning.prize(names.playerName("bbb")).value())).isTrue(),
                () -> assertThat(prizes.contains(winning.prize(names.playerName("ccc")).value())).isTrue()
        );
    }

}
