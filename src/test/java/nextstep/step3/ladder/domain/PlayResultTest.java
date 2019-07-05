package nextstep.step3.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

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
                                        new Link(0, true, false),
                                        new Link(1, false, true),
                                        new Link(2, false, false))),
                        new LadderLine(
                                Arrays.asList(
                                        new Link(0, false, false),
                                        new Link(1, false, false),
                                        new Link(2, false, false)))));
    }
    @DisplayName("전달받은 Index를 통해 endIndex를 통해 가지고 오기")
    @Test
    void findPrize() {
        Map<Integer, Integer> playResult = LadderFactory.play(ladder, 3);
        PlayResult result = new PlayResult(playResult);
        PrizeInfo info = PrizeInfo.of("5000,꽝,1000", 3);

        assertThat(result.findPrizeByIndex(1, info).equals(Prize.of(5000))).isTrue();
    }

    @DisplayName("전달받은 Index를 통해 firstIndex를 통해 가지고 오기")
    @Test
    void findName() {
        Map<Integer, Integer> playResult = LadderFactory.play(ladder, 3);
        PlayResult result = new PlayResult(playResult);
        Participant participant = Participant.of(
                Arrays.asList(
                        "kwon",
                        "byeon",
                        "yun"));

        assertThat(result.findNameByIndex(0, participant).equals(Name.of("kwon"))).isTrue();
    }

    @DisplayName("전달받은 Index를 통해 firstIndex를 통해 가지고 오기")
    @Test
    void findEndIndexByStartIndex() {
        Map<Integer, Integer> playResult = LadderFactory.play(ladder, 3);
        PlayResult result = new PlayResult(playResult);
        assertThat(result.findEndIndexByStartIndex(0)).isEqualTo(1);
    }
}