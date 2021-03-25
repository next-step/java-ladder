package laddarGame.domain;

import laddarGame.dto.LineDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LineTest {

    @DisplayName("가로라인은 중복될 수 없다.")
    @Test
    void isDuplicateHorizontal() {
        assertThrows(IllegalArgumentException.class,
                () -> new Line(List.of(true, true, false)));
    }

    @DisplayName("DTO 를 반환 한다.")
    @Test
    void createDto() {
        Line line = new Line(List.of(true, false, false));

        LineDto lineDto = line.lineDto();

        assertEquals(new LineDto(List.of(Point.of(true), Point.of(false), Point.of(false))), lineDto);
    }

    @DisplayName("사다리 라인에 따라 플레이어가 이동한다.")
    @Test
    void move() {
        Line line = new Line(List.of(true, false, false, true));
        Players players = createPlayers();

        line.move(players);

        assertEquals(players.getPlayer(0), new Player("SKT", 0));
        assertEquals(players.getPlayer(1), new Player("LG", 1));
        assertEquals(players.getPlayer(2), new Player("KT", 2));
        assertEquals(players.getPlayer(3), new Player("SKT", 3));

    }

    Players createPlayers() {
        return new Players(
                List.of(new Player("LG", 0)
                        , new Player("SKT", 1)
                        , new Player("KT", 2)
                        , new Player("TS", 3)));
    }

    Line createLine(boolean first, boolean second, boolean third, boolean fourth) {
        return new Line(List.of(first, second, third, fourth));
    }
}