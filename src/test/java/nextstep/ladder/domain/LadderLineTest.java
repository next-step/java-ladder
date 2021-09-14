package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderLineTest {

    @Test
    @DisplayName("사람 수 만큼 Points 리스트 수가 생성된다.")
    public void init() {
        int sizeOfPerson = 5;
        LadderLine ladderLine = LadderLine.init(sizeOfPerson, () -> true);
        assertThat(ladderLine.getPoints().size()).isEqualTo(sizeOfPerson);
    }

    @DisplayName("player가 1명이하면 게임을 시작할 수 없다.")
    @Test
    void initFirst() {
        assertThatThrownBy(() ->
                LadderLine.init(1, () -> true)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}