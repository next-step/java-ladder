package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderRowTest {
    @Test
    @DisplayName("성공 - LadderRow 객체를 생성할 때 주어진 넓이 만큼 사다리를 넓이를 생성한다.")
    void initTest() {
        LadderRow ladderRow = new LadderRow(new PositiveNumber(5), () -> true);
        assertThat(ladderRow.getRow()).hasSize(5);
    }

    @Test
    @DisplayName("성공 - getBar 메서드가 이전의 사다리 bar가 비어있으면 새로운 bar를 생성시킨다.")
    void generateLineTest() {
        LadderRow ladderRow = new LadderRow(new PositiveNumber(5), () -> true);
        assertThat(ladderRow.getRow().get(0)).isEqualTo("     ");
        assertThat(ladderRow.getRow().get(1)).isEqualTo("-----");
        assertThat(ladderRow.getRow().get(2)).isEqualTo("     ");
        assertThat(ladderRow.getRow().get(3)).isEqualTo("-----");
        assertThat(ladderRow.getRow().get(4)).isEqualTo("     ");
    }

    @Test
    @DisplayName("성공 - getBar 메서드가 첫 번째 Bar를 항상 비우고 생성한다.")
    void shouldCreateBarWithFirstBarEmpty() {
        LadderRow ladderRow1 = new LadderRow(new PositiveNumber(5), () -> true);
        LadderRow ladderRow2 = new LadderRow(new PositiveNumber(5), () -> false);
        assertThat(ladderRow1.getRow().get(0)).isEqualTo("     ");
        assertThat(ladderRow2.getRow().get(0)).isEqualTo("     ");
    }

    @Test
    @DisplayName("성공 - isRightMoveable 메서드가 현재위치+1 이 row의 크기보다 크거나 같다면 false를 반환한다.")
    void isRightMoveableTest() {
        LadderRow ladderRow = new LadderRow(new PositiveNumber(5), () -> true);
        System.out.println(ladderRow.getRow().size());
        assertThat(ladderRow.isRightMoveable(4)).isFalse();
    }

    @Test
    @DisplayName("성공 - isLeftMoveable 메서드가 현재위치-1 이 0보다 작다면 false를 반환한다.")
    void isLeftMoveableTest() {
        LadderRow ladderRow = new LadderRow(new PositiveNumber(5), () -> true);
        System.out.println(ladderRow.getRow().size());
        assertThat(ladderRow.isLeftMoveable(0)).isFalse();
    }
}