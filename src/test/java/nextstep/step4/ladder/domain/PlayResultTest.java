package nextstep.step4.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-07-03 17:58
 */
class PlayResultTest {
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        ladder = new Ladder(
                Arrays.asList(
                        new LadderLine(
                                Arrays.asList(
                                        new Point(0, new Direction(false, true)),
                                        new Point(1, new Direction(true, false)),
                                        new Point(2, new Direction(false, false)))),
                        new LadderLine(
                                Arrays.asList(
                                        new Point(0, new Direction(false, false)),
                                        new Point(1, new Direction(false, false)),
                                        new Point(2, new Direction(false, false))))));
    }

    @DisplayName("전달받은 Name을 통해 상금을 가지고 오기")
    @Test
    void findPrize() {
        Name name1 = Name.of("kwon");
        Name name2 = Name.of("be");
        Name name3 = Name.of("why");
        List<Name> names = Arrays.asList(name1, name2, name3);
        Participant participant = new Participant(names);

        Prize prize1 = Prize.of(1);
        Prize prize2 = Prize.of(2);
        Prize prize3 = Prize.of(3);
        List<Prize> prizes = Arrays.asList(prize1, prize2, prize3);
        PrizeInfo prizeInfo = new PrizeInfo(prizes);

        PlayResult result = new PlayResult(ladder.play(participant, prizeInfo));
        assertThat(result.findPrizeByName(name1)).isEqualTo(prize2);
    }
}