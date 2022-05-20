package nextstep.ladder.model;

import nextstep.ladder.exception.NameLengthExceedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PersonTest {

    @Test
    @DisplayName("Person 객체 생성")
    void create() {
        String name = "osean";
        assertThat(Person.of(name).toString()).isEqualTo(name);
    }

    @Test
    @DisplayName("Person 객체의 이름 최대 길이 예외 처리")
    void outOfLength() {
        String name = "helloWorld";
        assertThatThrownBy(() -> Person.of(name)).isExactlyInstanceOf(NameLengthExceedException.class);
    }
}