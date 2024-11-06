package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonImplTest {

    public static final PersonImpl P1 = new PersonImpl("hoya");
    public static final PersonImpl P2 = new PersonImpl("pobi");

    @Test
    @DisplayName("이름 길이가 제한 이내인 경우 Person 생성")
    void createPersonWithValidName() {
        assertEquals("hoya", P1.leftPad().trim());
    }

    @Test
    @DisplayName("이름이 5자를 초과할 경우 예외 발생")
    void createPersonWithNameExceedingLimitThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new PersonImpl("kimjooho"));
        assertEquals("The name allows up to 5 characters.", exception.getMessage());
    }

    @Test
    @DisplayName("이름이 5자 미만인 경우 좌측 패딩 확인")
    void leftPadShortName() {
        assertEquals(" hoya", P1.leftPad());
    }

    @Test
    @DisplayName("이름이 5자인 경우 좌측 패딩 확인")
    void leftPadExactLengthName() {
        PersonImpl personImpl = new PersonImpl("JooHo");
        assertEquals("JooHo", personImpl.leftPad());
    }

    @Test
    @DisplayName("동일한 이름을 가진 Person 객체 equals 비교")
    void equalsWithSameName() {
        assertEquals(P1, new PersonImpl("hoya"));
    }

    @Test
    @DisplayName("다른 이름을 가진 Person 객체 equals 비교")
    void equalsWithDifferentName() {
        assertNotEquals(P1, P2);
    }

    @Test
    @DisplayName("null과 equals 비교")
    void equalsWithNull() {
        assertNotEquals(P1, null);
    }

    @Test
    @DisplayName("다른 클래스 객체와 equals 비교")
    void equalsWithDifferentClass() {
        assertNotEquals(P1, "someString");
    }

    @Test
    @DisplayName("자기 자신과 equals 비교")
    void equalsWithSelf() {
        assertEquals(P1, P1);
    }
}