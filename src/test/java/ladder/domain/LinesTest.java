package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LinesTest {

    @DisplayName("팩토리 메서드 테스트")
    @Test
    public void of_success() throws Exception {
        //given
        Lines lines = Lines.of(5, 3);

        //then
        Assertions.assertThat(lines.getLines().size()).isEqualTo(3);
        Assertions.assertThat(lines.getLines().get(0).getNodes().size()).isEqualTo(5);
    }
}
