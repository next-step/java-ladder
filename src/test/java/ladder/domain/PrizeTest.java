package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PrizeTest {
    @Test
    void 생성자() {
        assertThat(new Prize("꽝,5000,꽝,3000", 4)).isInstanceOf(Prize.class);
    }

    @ParameterizedTest(name = "{displayName} [{index}] {arguments}")
    @NullAndEmptySource
    void Null또는빈값(String prizes) {
        assertThatThrownBy(() -> {
            new Prize(prizes, 3);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("상품이 입력되지 않았습니다.");

    }

    @Test
    void 상품개수상이() {
        assertThatThrownBy(() -> {
            new Prize("꽝,5000,꽝,3000", 3);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("입력한 상품의 개수가 참여자 수와 맞지 않습니다.");
    }

    @Test
    void 상품가져오기_인덱스음수() {
        Prize prize = new Prize("꽝,5000,꽝,3000", 4);

        assertThatThrownBy(() -> {
            prize.getPrize(-1);
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("입력된 수는 0 이상이어야 합니다.");
    }

    @Test
    void 상품가져오기_인덱스초과() {
        Prize prize = new Prize("꽝,5000,꽝,3000", 4);

        assertThatThrownBy(() -> {
            prize.getPrize(5);
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("입력된 수가 상품의 개수보다 큽니다.");
    }

    @Test
    void 상품가져오기() {
        Prize prize = new Prize("꽝,5000,꽝,3000", 4);

        assertThat(prize.getPrize(0)).isEqualTo("꽝");
        assertThat(prize.getPrize(3)).isEqualTo("3000");
    }
}
