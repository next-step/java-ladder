package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGeneratorTest {

    @DisplayName("입력한 개수의 Line과, 각 Line의 node 수 를 가지는 새로운 Lines 생성")
    @Test
    public void generateLines_success() throws Exception {
        //given
        LadderGenerator ladderGenerator = new LadderGenerator(3, 6);

        //when
        Lines lines = ladderGenerator.generateLines();

        //then
        assertThat(lines.size()).isEqualTo(6);
    }
}
