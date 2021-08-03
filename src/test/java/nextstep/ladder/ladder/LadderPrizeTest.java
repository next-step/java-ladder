package nextstep.ladder.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class LadderPrizeTest {

    LadderPrize prize;

    @BeforeEach
    void setup() {
        prize = LadderPrize.of("꽝,5000,꽝,3000");
    }

    @DisplayName("인덱스에 해당하는 상품 정보를 리턴한다.")
    @Test
    void get_prize() {

        assertThat(prize.findPrize(0)).isEqualTo("꽝");
        assertThat(prize.findPrize(3)).isEqualTo("3000");
    }

    @DisplayName("인덱스의 범위를 넘어서는 상품 정보를 조회시 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 10, 4})
    void index_out_of_bound(int index) {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> prize.findPrize(index))
                .withMessage("상품 정보는 0부터 3까지 조회 가능합니다.");
    }
}