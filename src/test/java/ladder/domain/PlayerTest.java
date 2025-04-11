package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayerTest {

    @Test
    @DisplayName("이름이 5글자가 넘어가면 예외를 반환한다.")
    void validateNameLengthTest_greaterThan5() {
        String name = "abcdef";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player(name));
    }

    @Test
    @DisplayName("이름이 5글자 이하이면 Player 객체를 생성한다.")
    void validateNameLengthTest_LessOrEqual5() {
        String name = "abcde";
        Player player = new Player(name);

        Assertions.assertEquals(name, player.getName());
    }

    @Test
    @DisplayName("이름이 동일하면 객체는 equal 하다")
    void equalsTest() {
        Player player1 = new Player("Alice");
        Player player2 = new Player("Alice");
        Player player3 = new Player("Bob");

        Assertions.assertEquals(player1, player2);
        Assertions.assertNotEquals(player1, player3);
    }

    @Test
    @DisplayName("이름이 동일하면 hashCode도 동일하다.")
    void hashCodeTest() {
        Player player1 = new Player("Alice");
        Player player2 = new Player("Alice");
        Player player3 = new Player("Bob");

        Assertions.assertEquals(player1.hashCode(), player2.hashCode());
        Assertions.assertNotEquals(player1.hashCode(), player3.hashCode());
    }

}
