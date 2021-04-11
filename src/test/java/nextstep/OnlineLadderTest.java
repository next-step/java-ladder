package nextstep;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OnlineLadderTest {
    @Test
    @DisplayName("게임?")
    void game() {
        Ladder ladder = new OnlineLadder(2);
        ladder.add("bong");
        ladder.add("big");
        ladder.move();
        assertThat(ladder.heights()).contains(1);
    }

    @Test
    @DisplayName("사다리그리기테스트")
    void ladderString() {
        Coordinates coordinates = new Coordinates();
        coordinates.add(new Coordinate("bong", 0, 0));
        coordinates.add(new Coordinate("big", 0, 0));

        Ladder ladder1 = new OnlineLadder(2, coordinates, 3);
        ladder1.lineMark(0, 2);
        assertThat(ladder1.ladderString(0)).isEqualTo("|     |     |-----|");

        Ladder ladder2 = new OnlineLadder(2, coordinates, 3);
        ladder2.lineMark(0, 1);
        assertThat(ladder2.ladderString(0)).isEqualTo("|     |-----|     |");

        Ladder ladder3 = new OnlineLadder(2, coordinates, 3);
        ladder3.lineMark(1, 1);
        assertThat(ladder3.ladderString(0)).isNotEqualTo("|     |-----|     |");
        assertThat(ladder3.ladderString(1)).isEqualTo("|     |-----|     |");
    }
}
