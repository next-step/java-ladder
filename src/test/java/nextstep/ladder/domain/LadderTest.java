package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {
    @Test
    @DisplayName("성공 - Ladder를 생성했을 떄 주어진 넓이와 높이만큼의 map이 생성된다.")
    void initTest() {
        Ladder ladder = new Ladder(new PositiveNumber(3), new PositiveNumber(5));
        List<LadderRow> ladderMap = ladder.getMap();
        assertThat(ladderMap).hasSize(5);
        ladderMap.forEach(row ->
                assertThat(row.getRow()).hasSize(3)
        );
    }

    @Test
    @DisplayName("실패 - getMap 메서드의 반환된 List를 수정했을 때 예외가 발생한다.")
    void throwExceptionWhenModifyingReturnedList() {
        Ladder ladder = new Ladder(new PositiveNumber(3), new PositiveNumber(5));
        assertThatThrownBy(() -> ladder.getMap().add(new LadderRow(new PositiveNumber(3), () -> true)))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}