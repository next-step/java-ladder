package nextstep.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("Person 객체 생성 담당")
public class PersonFactoryTest {

    @DisplayName("Person 생성")
    @Test
    public void createPerson() {
        assertThatIllegalArgumentException().isThrownBy(() -> PersonFactory.createPerson(""));
        assertThatIllegalArgumentException().isThrownBy(() -> PersonFactory.createPerson("  "));
        assertThatIllegalArgumentException().isThrownBy(() -> PersonFactory.createPerson("이주영12345"));
    }

    @DisplayName("Persons 생성")
    @Test
    public void createPersons() {
        assertThatIllegalArgumentException().isThrownBy(() -> PersonFactory.createPersons(new String[] { "", "이주영" }));
        assertThatIllegalArgumentException().isThrownBy(() -> PersonFactory.createPersons(new String[] { "  ", "이가영" }));
        assertThatIllegalArgumentException().isThrownBy(() -> PersonFactory.createPersons(new String[] { "이주영12345", "1134" }));
        assertThatIllegalArgumentException().isThrownBy(() -> PersonFactory.createPersons("이주영12345,1134"));
    }

}
