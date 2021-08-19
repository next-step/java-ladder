package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AwardsTest {

    @Test
    @DisplayName("상금 일급 컬렉션 객체 생성")
    void construct() throws Exception {
        //given
        String namesOfAwards = "fail,5000,fail,3000";

        //when
        Awards actual = Awards.from(namesOfAwards);

        //then
        assertThat(actual).isEqualTo(Awards.from(namesOfAwards));

    }
}
