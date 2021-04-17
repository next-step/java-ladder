package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderResultBoardTest {

    @DisplayName("LadderResultBoard 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        Map<Person, String> resultBoard = new HashMap<>();

        // when
        LadderResultBoard ladderResultBoard = LadderResultBoard.of(resultBoard);

        // then
        assertThat(ladderResultBoard).isNotNull();
    }

    @DisplayName("LadderResultBoard 인스턴스 특정 사람에 대한 결과 반환 테스트")
    @Test
    void 반환_특정사람() {
        // given
        Map<Person, String> resultBoard = new HashMap<>();
        String expected = "성공";
        resultBoard.put(Person.of("userA"), "실패");
        resultBoard.put(Person.of("userB"), expected);
        resultBoard.put(Person.of("userC"), "실패");

        // when
        LadderResultBoard ladderResultBoard = LadderResultBoard.of(resultBoard);
        String actual = ladderResultBoard.findResult(Person.of("userB"));

        // then
        assertThat(actual).isEqualTo(expected);
    }

}