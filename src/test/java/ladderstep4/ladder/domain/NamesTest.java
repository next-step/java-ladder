package ladderstep4.ladder.domain;

import ladder.domain.Names;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NamesTest {

    @DisplayName(",로 구분하여 Names 생성")
    @Test
    void create() {
        Names names = new Names("pobi, honux, crong, jk");

        assertThat(names.getValue()).hasSize(4);
    }

    @DisplayName("생성 파라미터는 비어있을 수 없음")
    @Test
    void create_empty() {
        assertThatThrownBy(() -> new Names(","))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력이 비어있을 수 없습니다.");
    }

}
