package nextstep.ladder.domain.line;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinningCategoriesTest {

    @Test
    public void 당첨항목_생성테스트() {
        //given when
        WinningCategories winningCategories = new WinningCategories("꽝,5000,꽝,3000");

        //then
        assertThat(winningCategories.size()).isEqualTo(4);
    }

    @Test
    public void Invalid_입력값() {
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningCategories(""));
    }
}