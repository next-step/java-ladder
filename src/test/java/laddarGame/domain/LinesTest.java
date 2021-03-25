package laddarGame.domain;

import laddarGame.dto.LineDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinesTest {

    @DisplayName("입력된 높이 만큼 사다리 게임을 생성한다.")
    @Test
    void createLadder() {
        Lines lines = new Lines(3, 4);

        assertEquals(4, lines.linesDto().size());
    }

    @DisplayName("Dto를 생성한다.")
    @Test
    void createDto() {
        Lines lines = new Lines(createLines());

        List<LineDto> lineDtos = lines.linesDto();

        assertEquals(new LineDto(true, false, true, false), lineDtos.get(0));
    }

    @DisplayName("사다리 게임에 따라 플레이어가 이동한다..")
    @Test
    void move() {
        Players players = createPlayers();
        Lines lines = new Lines(createLines());

        Players resultPlayers = lines.play(players);

        assertEquals(new Player("SKT", 0), resultPlayers.getPlayer(0));
        assertEquals(new Player("TS", 1), resultPlayers.getPlayer(1));
        assertEquals(new Player("LG", 2), resultPlayers.getPlayer(2));
        assertEquals(new Player("KT", 3), resultPlayers.getPlayer(3));


    }

    Players createPlayers() {
        return new Players(
                List.of(new Player("LG", 0)
                        , new Player("SKT", 1)
                        , new Player("KT", 2)
                        , new Player("TS", 3)));
    }

    List<Line> createLines() {  //LG              SKT          KT           TS
        return List.of(createLine(true, false, true, false)
                , createLine(false, true, false, true)
                , createLine(true, false, true, false)
                , createLine(true, false, true, false));
    }                              // SKT           TS        KT               LG

    Line createLine(boolean first, boolean second, boolean third, boolean fourth) {
        return new Line(List.of(first, second, third, fourth));
    }

}
