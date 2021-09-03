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
        LadderLine ladderLine = LadderLine.init(sizeOfPerson);
        assertThat(ladderLine.size()).isEqualTo(sizeOfPerson);
    }

    @DisplayName("player 가 1명이하면 게임을 시작할 수 없다. " +
            "로직상 최소 3명이상이어야 게임을 시작할 수 있고, 2명일 땐 사다리 라인이 생기지 않는다.")
    @Test
    void initFirst() {
        assertThatThrownBy(() -> LadderLine.init(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("player 수가 2명일 때, 0 위치에서 사다리를 타면 라인이 생성되지 않기때문에 0 이 나온다.")
    @Test
    public void move() {
        LadderLine line = LadderLine.init(2);
        assertThat(line.move(0)).isEqualTo(0);
    }

}