package nextstep.ladder.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LineTest {

    @ParameterizedTest(name = "사람 수가 주어질 때, 가로 이동이 가능한 Line 객체를 생성합니다; 사람 수: {0}")
    @ValueSource(ints = {2, 3, 4, 5})
    void create(int countOfPerson) {
        Line line = new Line(countOfPerson);
    }

    @ParameterizedTest(name = "부족한 인원의 사람 수가 주어질 때, 예외를 반환합니다.")
    @ValueSource(ints = {0, 1})
    void createWithInsufficientPeopleCount(int countOfPerson) {
        assertThatThrownBy(() -> new Line(countOfPerson))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("최소 2명이 존재해야 사다리에서 이동이 가능합니다");
    }
}
