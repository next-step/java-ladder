package ladder.domain.element;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PrizesTest {

    @Test
    @DisplayName("text blank 설정")
    void testPrizesFromTextBlank() {
        assertThatThrownBy(() -> Prizes.fromText("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Prizes.fromText(" ")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Prizes.fromText(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("실행 결과 정상 생성")
    void testCreatePrizes() {
        // given
        String[] results = { "꽝","5000","꽝!","3000" };
        // when
        Prizes prizes = Prizes.fromText(String.join(",", results));
        // then
        for (Prize prize : prizes) {
            assertThat(results).contains(prize.getName());
        }
    }

    @Test
    @DisplayName("실행 결과 크기")
    void testPrizesSize() {
        // given
        String[] results = { "꽝","5000","꽝!","3000" };
        // when
        Prizes prizes = Prizes.fromText(String.join(",", results));
        // then
        assertThat(prizes.size()).isEqualTo(results.length);
    }

    @Test
    @DisplayName("정상 수행 후 prize 확인")
    void testGetPrize() {
        // given
        String[] results = { "꽝","5000","꽝!","3000" };
        // when
        Prizes prizes = Prizes.fromText(String.join(",", results));
        // then
        for (int i = 0; i < results.length; i++) {
            Prize prize = prizes.get(i);
            assertThat(prize.getName()).isEqualTo(results[i]);
        }
    }
}
