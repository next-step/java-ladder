package ladder2.domain;

import static ladder2.domain.Link.LEFT_LINK;
import static ladder2.domain.Link.NO_LINK;
import static ladder2.domain.Link.RIGHT_LINK;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderRowTest {

    @Test
    @DisplayName("성공적으로 인스턴스화된다")
    void new_success() {
        assertThatNoException()
            .isThrownBy(() -> LadderRow.of(RIGHT_LINK, LEFT_LINK));
    }

    @Test
    @DisplayName("열들의 index가 올바르지 않을 경우 예외가 발생한다")
    void new_illegal_index_exception() {
        List<LadderColumn> columns = List.of(
            new LadderColumn(999, NO_LINK)
        );
        assertThatThrownBy(() -> new LadderRow(columns))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("열이 1개도 없다면 예외가 발생한다")
    void new_empty_exception() {
        assertThatThrownBy(() -> new LadderRow(List.of()))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("빈 곳을 가르키는 링크가 있다면 예외가 발생한다")
    void new_link_to_null_exception() {
        assertThatThrownBy(() -> LadderRow.of(LEFT_LINK))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("링크가 양방향이 아니라면 예외가 발생한다")
    void new_link_not_two_way_link_exception() {
        assertThatThrownBy(() -> LadderRow.of(LEFT_LINK, LEFT_LINK))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
