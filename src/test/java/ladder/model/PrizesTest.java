package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.model.Prizes.INVALID_NUMBER_OF_PRIZES;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrizesTest {

    @Test
    @DisplayName("Prizes.of 정적 메서드로 Prizes 객체 정상 생성")
    void testPrizes_of_ShouldReturnPrizes() {
        // given
        List<String> prizeNames = List.of("연봉 1억", "연봉 동결", "스톡 옵션");
        int numberOfParticipants = 3;

        // when
        Prizes prizes = Prizes.of(prizeNames, numberOfParticipants);

        // then
        assertAll(
                "All Prizes are saved correctly",
                () -> assertEquals(prizes.getPrizeAt(0).getPrizeName(), "연봉 1억"),
                () -> assertEquals(prizes.getPrizeAt(1).getPrizeName(), "연봉 동결"),
                () -> assertEquals(prizes.getPrizeAt(2).getPrizeName(), "스톡 옵션")
        );
    }

    @Test
    @DisplayName("참가자의 숫자와 상품의 개수가 일치하지 않아 Prizes 객체 생성 실패")
    void testPrizes_mismatchedCountOfParticipantsAndPrizes_ShouldThrowException() {
        // given
        List<String> prizeNames = List.of("연봉 1억", "연봉 동결", "스톡 옵션");
        int numberOfParticipants = 1;

        // when, then
        assertThatIllegalArgumentException().isThrownBy(() -> {
           Prizes.of(prizeNames, numberOfParticipants);
        }).withMessageContaining(INVALID_NUMBER_OF_PRIZES);
    }
}
