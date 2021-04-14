package step4.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import step4.exception.NotEqualCountException;
import step4.exception.NotFoundException;
import step4.util.StringSpliter;

public class PrizesTest {
    @Test
    void 생성_테스트() {
        // given
        String test = "꽝,500, 꽝, 3000";
        Prizes prizes = Prizes.of(test, 4);
        // when & then
        assertThat(prizes.prizes().size()).isEqualTo(4);
    }

    @Test
    void 생성_테스트_2() {
        // given
        String test = "꽝,500, 꽝, 3000";
        Prizes prizes = Prizes.of(test, 4);
        Prizes comparePrizes = Prizes.of(StringSpliter.split(test), 4);
        // when & then
        assertThat(prizes).isEqualTo(comparePrizes);
    }

    @Test
    void 상품수_플레이어수_비교_테스트() {
        // given
        String test = "꽝,500, 꽝, 3000";
        // when & then
        Assertions.assertThrows(NotEqualCountException.class, () -> Prizes.of(test, 3));
    }

    @Test
    void 결과_매칭_테스트() {
        // given
        String test = "꽝,500, 꽝, 3000";
        Prizes prizes = Prizes.of(test, 4);
        // when & then
        assertThat(prizes.matchPosition(Position.valueOf(1))).isEqualTo(new Prize(1, "500"));
    }

    @Test
    void 존재하지않는_상품_테스트() {
        // given
        String test = "꽝,500, 꽝, 3000";
        Prizes prizes = Prizes.of(test, 4);
        // when & then
        Assertions.assertThrows(NotFoundException.class, () -> prizes.matchPosition(Position.valueOf(5)));
    }
}
