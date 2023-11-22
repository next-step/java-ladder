package me.namuhuchutong.ladder;

import me.namuhuchutong.ladder.domain.LadderGameResultSequence;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LadderGameResultSequenceTest {

    @DisplayName("주어진 수는 콜렉션의 범위를 벗어날 경우 예외가 발생한다.")
    @Test
    void throw_exception_when_index_exceed_size() {
        List<Integer> givenList = List.of(1, 3, 5, 7);
        int givenIndex = 5;
        LadderGameResultSequence sequence = new LadderGameResultSequence(givenList);

        assertThatThrownBy(() -> sequence.convert(givenIndex))
                .isInstanceOf(IllegalArgumentException.class);
    }
}