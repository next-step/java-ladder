package nextstep.ladder;

import nextstep.ladder.model.Gamers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GamersTest {

    @Test
    void 참가자_수_확인() {
        Gamers gamers = new Gamers("Anna,Max,Tom");

        assertEquals(3, gamers.getCountOfPerson());
    }

    @Test
    void 참가자_이름_목록_확인() {
        Gamers gamers = new Gamers("Anna,Max,Tom");

        assertThat(gamers.getGamerNames()).containsExactly("Anna", "Max", "Tom");
    }

    @Test
    void 참가자가_한_명일_때_이름_확인() {
        Gamers gamers = new Gamers("Anna");

        assertEquals(1, gamers.getCountOfPerson());
        assertThat(gamers.getGamerNames()).containsExactly("Anna");
    }

    @Test
    void 참가자_이름_빈_문자열일_때() {
        assertThatThrownBy(() -> new Gamers(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 빈 문자열이 될 수 없습니다.");
    }

    @Test
    void 특정_위치의_참가자_이름_확인() {
        Gamers gamers = new Gamers("Anna,Max,Tom");

        assertEquals("Anna", gamers.getGamerNameByPosition(0));
        assertEquals("Max", gamers.getGamerNameByPosition(1));
        assertEquals("Tom", gamers.getGamerNameByPosition(2));
    }

    @Test
    void 잘못된_위치의_참가자_이름_요청_시_예외() {
        Gamers gamers = new Gamers("Anna,Max,Tom");

        assertThatThrownBy(() -> gamers.getGamerNameByPosition(3))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }
}
