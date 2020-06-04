package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @Test
    @DisplayName("사람 이름이 5글자 초과할 경우")
    void LadderCreator() {
        String[] personNames = {"a", "watermelon", "c"};

        assertThatThrownBy(() -> {
            new Ladder(personNames, 3);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("사람 이름은 최대 5글자까지 입니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("사다리 높이 체크")
    void createLadder(int ladderHeight) {
        String[] personNames = {"a", "b", "c"};
        Ladder ladder = new Ladder(personNames, ladderHeight);

        LineList lineList = ladder.createLadder();

        int ladderHeightResult = lineList.getLineList().size();
        assertThat(ladderHeightResult).isEqualTo(ladderHeight);
    }
}
