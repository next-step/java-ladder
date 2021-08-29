package nextstep.ladder.domain;

import nextstep.ladder.domain.engine.Board;
import nextstep.ladder.domain.engine.PlayResult;
import nextstep.ladder.domain.impl.board.LadderBoard;
import nextstep.ladder.domain.impl.line.LadderLine;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderBoardTest {

    @DisplayName("Line 리스트를 매개변수로 게임을 생성한다.")
    @Test
    void create() {
        List<LadderLine> ladderLines = Lists.list(LadderLine.from(true, false, true), LadderLine.from(true, false, true));
        assertThat(LadderBoard.from(ladderLines)).isEqualTo(LadderBoard.from(ladderLines));
    }

//    @DisplayName("게임에 참가하지 않은 Player 입력시 에러가 발생한다.")
//    @Test
//    void validPlayerForResult() {
//        String playerNames = "pobi,honux,crong,jk";
//        List<Line> lines = Lists.list(Line.from(true, false, true), Line.from(true, false, true));
//        Board board = Board.from(playerNames, lines);
//
//        assertThatThrownBy(() -> board.play(Collections.singletonList(Player.from("hello"))))
//                .isInstanceOf(IllegalArgumentException.class);
//    }

    @DisplayName("play함수 매개변수로 player list를 입력하면 결과위치 리스트를 출력한다.")
    @Test
    void play() {
        List<LadderLine> ladderLines = Lists.list(
                LadderLine.from(false, true, false, true),
                LadderLine.from(false, false, true, false),
                LadderLine.from(false, true, false, false),
                LadderLine.from(false, false, true, false),
                LadderLine.from(false, true, false, true));
        Board ladderBoard = LadderBoard.from(ladderLines);

        PlayResult expect = new PlayResult(new HashMap<Integer, Integer>() {{
            put(0, 0);
            put(1, 3);
            put(2, 2);
            put(3, 1);
        }});

        PlayResult result_all = ladderBoard.play();
        assertThat(result_all).isEqualTo(expect);
    }
}
