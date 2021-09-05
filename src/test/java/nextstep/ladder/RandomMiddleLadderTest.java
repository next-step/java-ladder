package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMiddleLadderTest {

    @Test
    @DisplayName("true 생성 다음건은 무조건 false 생성")
    void checkRandomCreateLogic() {

        RandomMiddleLadder random = new RandomMiddleLadder();
        random.preStatus = true;
        assertThat(random.makeBoolean()).isEqualTo(false);

    }

}