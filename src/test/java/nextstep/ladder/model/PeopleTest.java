package nextstep.ladder.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PeopleTest {
    @Test
    @DisplayName("여러 명의 인원의 이름이 주어질 때 people 객체를 생성한다.")
    void create() {
        List<String> peopleNames = List.of("hello", "world", "abc");
        People people = new People(peopleNames);
    }

    @Test
    @DisplayName("중복된 사람의 이름이 주어질 때 예외를 던진다.")
    void createWithDuplicatePeopleNames() {
        List<String> duplicatedPeopleNames = List.of("hello", "hello", "world");
        assertThatThrownBy(() -> new People(duplicatedPeopleNames))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("중복된 이름이 존재할 수 없습니다");
    }

    @Test
    @DisplayName("인원 수가 부족할 경우 예외를 던진다.")
    void createWithInsufficientPeopleCount() {
        List<String> onePersonName = List.of("hello");
        assertThatThrownBy(() -> new People(onePersonName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("최소 2명 이상의 인원이 존재해야 합니다");
    }
}
