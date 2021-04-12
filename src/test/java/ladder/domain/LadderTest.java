package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("Ladder 인스턴스 Null 주입시 예외처리 여부 테스트")
    @Test
    void 검증_NULL() {
        // given
        List<Line> lines = null;

        // when
        assertThatThrownBy(() -> Ladder.from(lines))
                .isInstanceOf(LineListNullPointerException.class)
                .hasMessage("List<Line>이 null 입니다.");
    }
}