package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderLineTest {
    @DisplayName("LadderLine 생성, 사람 수 만큼 Points 리스트 수가 생성된다.")
    @Test
    public void init() {
        int sizeOfPerson = 5;
        LadderLine ladderLine = LadderLine.init(sizeOfPerson, () -> true);
        assertThat(ladderLine.size()).isEqualTo(sizeOfPerson);
    }

    @DisplayName("player 가 1명이하면 게임을 시작할 수 없다.")
    @Test
    void initFirst() {
        assertThatThrownBy(() -> LadderLine.init(1, () -> true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("player 수가 2명일 때")
    @Test
    public void move() {
        LadderLine line = LadderLine.init(2, () -> true);
        assertThat(line.move(0)).isEqualTo(1);
    }

    @DisplayName("player 수가 3명일 때")
    @Test
    public void move2() {
        //      1      2      3
        //      |------|      |
        //      2      1      3
        LadderLine line = LadderLine.init(3, () -> true);
        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(0);
        assertThat(line.move(2)).isEqualTo(2);
    }

}