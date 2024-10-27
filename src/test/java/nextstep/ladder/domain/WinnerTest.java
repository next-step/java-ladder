package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class WinnerTest {

    public static final Person PERSON = new Person("hoya");
    public static final String RESULT = "1등";
    public static final Winner WINNER = new Winner(PERSON, RESULT);

    @Test
    @DisplayName("Winner 객체를 생성하고 속성을 설정한다")
    void testWinnerCreation() {
        assertEquals(PERSON, WINNER.getPerson());
        assertEquals(RESULT, WINNER.getResult());
        assertEquals("hoya", WINNER.getName());
    }


    @Test
    @DisplayName("동일한 속성을 가진 Winner 객체 equals 비교")
    void winnerEqualsWithSameProperties() {
        assertEquals(new Winner(PERSON, RESULT), new Winner(PERSON, RESULT));
    }

    @Test
    @DisplayName("서로 다른 속성을 가진 Winner 객체 equals 비교")
    void winnerNotEqualsWithDifferentProperties() {
        assertNotEquals(WINNER, new Winner(new Person("dhmin"), "1등"));
    }

    @Test
    @DisplayName("null 객체와 equals 비교")
    void winnerNotEqualsWithNull() {
        assertNotEquals(WINNER, null);
    }

    @Test
    @DisplayName("다른 클래스 객체와 equals 비교")
    void winnerNotEqualsWithDifferentClass() {
        assertNotEquals(WINNER, "someString");
    }

    @Test
    @DisplayName("자기 자신과 equals 비교")
    void winnerEqualsWithSelf() {
        assertEquals(WINNER, WINNER);
    }
}
