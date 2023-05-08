package nextstep.ladder.line;

import nextstep.ladder.domain.line.Lines;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LinesTest {
    @Test
    @DisplayName("라인 목록 생성 함수")
    void create() {
        assertThat(new Lines(3, 4, "1,1,2,3"))
                .extracting("lines")
                .asList()
                .hasSize(3);
    }

    @Test
    @DisplayName("리워드가 빈 값일 경우 Exception 발생")
    void emptyReward() {
        assertThatThrownBy(() -> new Lines(3, 4, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보상은 빈값일 수 없습니다.");
    }

    @Test
    @DisplayName("리워드가 참여자 인수와 맞지 않을경우 Exception 발생")
    void notEqualSize() {
        assertThatThrownBy(() -> new Lines(3, 4, "1,2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보상은 인원수와 같아야합니다.");
    }
}
