package ladder.view;

import ladder.domain.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class ParserTest {
    @Test
    @DisplayName("이름을 , 로 구분하고 User 리스트로 반환한다.")
    void parseStringToPlayerTest() {
        String input = "aa, bb, cc";
        List<Player> expected = List.of(
                new Player("aa"),
                new Player("bb"),
                new Player("cc")
        );

        List<Player> result = Parser.parseStringToPlayer(input);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("이름이 공백이면 User 객체로 변환하지 않는다.")
    void parseStringToPlayerTest_emptyName() {
        String input = "aa,  , ";
        List<Player> expected = List.of(
                new Player("aa")
        );

        List<Player> result = Parser.parseStringToPlayer(input);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("중복된 이름이 존재하면 하나의 User 객체로 판단한다.")
    void parseStringPlayerTest_duplicateName() {
        String input = "aa, bb, aa, bb";
        List<Player> expected = List.of(
                new Player("aa"),
                new Player("bb")
        );

        List<Player> result = Parser.parseStringToPlayer(input);

        Assertions.assertEquals(expected, result);
    }
}
