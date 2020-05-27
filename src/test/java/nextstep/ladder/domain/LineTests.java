package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTests {
    @DisplayName("참여하는 인원수를 입력받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        int countOfPerson = 3;
        Line line = new Line(countOfPerson);
        assertThat(line).isNotNull();
    }
}
