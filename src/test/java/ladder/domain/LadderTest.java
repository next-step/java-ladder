package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("Ladder 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        People people = People.of("pobi,honux,crong,jk");
        int height = 5;

        // when
        Ladder ladder = Ladder.from(people, height);

        // then
        assertThat(ladder).isNotNull();
    }
}