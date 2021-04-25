package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HeadingTest {

    @DisplayName("Heading enum 생성 여부 테스트")
    @Test
    void 생성() {
        assertAll(
                () -> assertThat(Heading.RIGHT).isNotNull(),
                () -> assertThat(Heading.LEFT).isNotNull(),
                () -> assertThat(Heading.PASS).isNotNull()
        );
    }

    @DisplayName("Heading 열거형이 각각의 상수에 맞게끔 다음 이동 인덱스 반환 테스트")
    @Test
    void 이동() {
        // given
        int position = 1;

        assertAll(
                () -> assertThat(Heading.RIGHT.move(position)).isEqualTo(2),
                () -> assertThat(Heading.LEFT.move(position)).isEqualTo(0),
                () -> assertThat(Heading.PASS.move(position)).isEqualTo(1)
        );
    }

}