package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AwardsTest {

    @DisplayName("Awards 생성 테스트")
    @Test
    void awardsConstructorTest(){
        // given
        String[] awardNames = {"꽝", "5000", "1500"};

        // when
        Awards awards = new Awards(awardNames);

        // then
        assertThat(awards.getAwards()).containsExactly(new Award("꽝"), new Award("5000"), new Award("1500"));
    }
}
