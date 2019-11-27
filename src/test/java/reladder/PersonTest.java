package reladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reladder.domain.Person;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PersonTest {

    @Test
    @DisplayName("생성자 정상 생성 테스트")
    void createConstructorTest() {
        // give
        Person person = new Person("tom", 1);
        // when
        int position = person.getPosition();
        String name = person.getName();
        // then
        assertThat(position).isEqualTo(1);
        assertThat(name).isEqualTo("tom");
    }

    @Test
    @DisplayName("생성된 객체의 이름을 포함하고 있는지")
    void containsPersonByName() {
        // give
        Person person = new Person("tom", 1);
        // when
        boolean isContain = person.matchNameContainsExactly("tom");
        boolean isContain2 = person.matchNameContainsExactly("tom2");
        // then
        assertThat(isContain).isTrue();
        assertThat(isContain2).isFalse();
    }

    @Test
    @DisplayName("객체가 생성될 때 유효성 검사")
    void validateByPerson() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Person person = new Person("kimseongju", 1);
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            Person person2 = new Person("tom", -1);
        });
    }
}
