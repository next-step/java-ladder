package reladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reladder.domain.People;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PeopleTest {

    private People people;

    @BeforeEach
    void setUp() {
        // give
        people = new People("iron,black,pink,des");
    }

    @Test
    @DisplayName("사람 수 테스트")
    void checkSizeOfPeopleTest() {
        // when
        int size = people.size();
        // then
        assertThat(size).isEqualTo(4);
    }

    @Test
    @DisplayName("사람 이름으로 찾기")
    void findPersonWithName() {
        // when
        String name = people.getPersonName("iron");
        // then
        assertThat(name).isEqualTo("iron");
    }

    @Test
    @DisplayName("글자수 초과시 익셉션 테스트")
    void overLengthExceptionTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            People people = new People("iron_man_mk2");
        });
    }
}
