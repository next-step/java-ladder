package ladder.domain;

import ladder.domain.Person;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PersonTest {
    @Test
    void 생성_테스트() {
        assertThatCode(() -> Person.create("eunji")).doesNotThrowAnyException();
    }

    @Test
    void 이름은_5글자_까지(){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Person.create("parkeunji"))
                .withMessageContaining("이름은 최대 5글자 까지 가능 합니다.");
    }
}
