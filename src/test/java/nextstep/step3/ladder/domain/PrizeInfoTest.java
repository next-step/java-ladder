package nextstep.step3.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-07-01 21:38
 */
public class PrizeInfoTest {
    @DisplayName("결과정보 생성 - 예외상황(참여자의 수와 결과가 다를 경우)")
    @Test
    void createWinInfoDifferent() {
        Participant participant = Participant.of(
                Arrays.asList(
                        "kwon",
                        "byeon",
                        "yun"));
        int participantCount = participant.count();

        assertThatIllegalArgumentException().isThrownBy(() -> {
            PrizeInfo info = PrizeInfo.of(
                    Arrays.asList(
                            Prize.of(5000),
                            Prize.of("꽝")), participantCount);
        }).withMessageContaining("결과값이 참여자와 다릅니다.");
    }

    @DisplayName("결과정보 생성 - 예외상황(Null)")
    @Test
    void createWinInfoNull() {
        Participant participant = Participant.of(
                Arrays.asList(
                        "kwon",
                        "byeon",
                        "yun"));
        int participantCount = participant.count();

        assertThatIllegalArgumentException().isThrownBy(() -> {
            PrizeInfo info = PrizeInfo.of(null, participantCount);
        }).withMessageContaining("실행 결과 값이 없습니다.");
    }

    @DisplayName("결과정보 생성 - 예외상황(Null)")
    @Test
    void createWinInfoEmpty() {
        Participant participant = Participant.of(
                Arrays.asList(
                        "kwon",
                        "byeon",
                        "yun"));
        int participantCount = participant.count();

        assertThatIllegalArgumentException().isThrownBy(() -> {
            PrizeInfo info = PrizeInfo.of(
                    Arrays.asList(), participantCount);
        }).withMessageContaining("실행 결과 값이 없습니다.");
    }
}
