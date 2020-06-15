package nextstep.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Persons;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PersonsTest {

    @Test
    @DisplayName("사람 쉼표로 구분하여 입력후 사람수 정확한지 테스트 ")
    void countPersonTest(){
        Persons persons = Persons.of("pobi,honux,crong,jk");
        assertThat(persons.count()).isEqualTo(4);
    }

    @Test
    @DisplayName("사람수 유효성 테스트 ")
    void countPersonExceptionTest(){
        assertThatThrownBy(() -> Persons.of("pobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
