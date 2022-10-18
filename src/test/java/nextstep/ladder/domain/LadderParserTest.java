package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderParserTest {

    @Test
    @DisplayName("입력 받은 사람의 이름의 타입을 파싱한다.(String[] -> List<Person>)")
    void stringArrayToListPerson() {
        assertThat(LadderParser.listPerson(new String[]{"정우성", "이정재"}))
                .isInstanceOf(List.class);
    }
}
