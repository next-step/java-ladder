package laddarGame.domain;

import laddarGame.dto.LineDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LadderTest {

    @DisplayName("입력된 높이 만큼 사다리 게임을 생성한다.")
    @Test
    void createLadder() {
        Ladder ladder = new Ladder(3, 4);

        assertEquals(4, ladder.linesDto().size());
    }

    @DisplayName("Dto를 생성한다.")
    @Test
    void createDto() {
        Ladder ladder = new Ladder(createLines());

        List<LineDto> lineDtos = ladder.linesDto();

        assertEquals(new LineDto(true, false, true, false), lineDtos.get(0));
    }

    @DisplayName("사다리 게임에 따라 플레이어가 이동한다..")
    @Test
    void move() {
        Players players = createPlayers();
        Ladder ladder = new Ladder(createLines());

        List<String> resultPlayers = ladder.play(players);

        assertEquals("SKT", resultPlayers.get(0));
        assertEquals("TS", resultPlayers.get(1));
        assertEquals("LG", resultPlayers.get(2));
        assertEquals("KT", resultPlayers.get(3));
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
