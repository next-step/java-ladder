package nextstep.ladder.domain;

import nextstep.ladder.domain.line.Line;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    @DisplayName("Line 리스트를 매개변수로 게임을 생성한다.")
    @Test
    void create() {
        List<Line> lines = Lists.list(Line.from(true, false, true), Line.from(true, false, true));
        assertThat(Board.from(lines)).isEqualTo(Board.from(lines));
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
    @ParameterizedTest
    @CsvSource(value = {"0,0", "1,3", "2,2", "3,1"})
    void play(int input, int expected) {
        List<Line> lines = Lists.list(
                Line.from(false, true, false, true),
                Line.from(false, false, true, false),
                Line.from(false, true, false, false),
                Line.from(false, false, true, false),
                Line.from(false, true, false, true));
        Board board = Board.from(lines);

        Map<Integer, Integer> result_all = board.play();
        assertThat(result_all).extractingByKey(input).isEqualTo(expected);
    }
}
