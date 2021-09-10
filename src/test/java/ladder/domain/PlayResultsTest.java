package ladder.domain;

import ladder.util.StringUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayResultsTest {

    @DisplayName("생성")
    @Test
    void create() {
        PlayResults playResults = new PlayResults(StringUtil.split("꽝,5000원,10000원"));
        assertThat(playResults.getPlayResults()).hasSize(3);
    }

    @DisplayName("입력 값 사이즈가 2보다 작을 경우 IllegalArgumentException 발생")
    @Test
    void create_ThrowsIllegalArgumentException_IfInputSizeIsLessThanTwo() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new PlayResults(StringUtil.split("꽝"))
        );
    }

    @DisplayName("입력 값과 PlayResult 길이가 동일한지 확인")
    @Test
    void isSameLength() {
        PlayResults playResults = new PlayResults(StringUtil.split("꽝,5000원,10000원"));
        assertThat(playResults.isSameLength(3)).isTrue();
    }
}