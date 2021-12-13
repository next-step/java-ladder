package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderStringsTest {

    @DisplayName("생성 파라미터는 null일 수 없음")
    @Test
    void create_null() {
        assertThatThrownBy(() -> new LadderStrings(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력이 null일 수 없습니다.");
    }

    @DisplayName("생성 파라미터는 비어있을 수 없음")
    @Test
    void create_empty() {
        assertThatThrownBy(() -> new LadderStrings<>(new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력이 비어있을 수 없습니다.");
    }

}
