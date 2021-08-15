package ladder.domain;

import ladder.exception.InvalidPersonNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ParticipatePeopleTests {
    @DisplayName("생성 테스트")
    @Test
    void create() {
        List<String> participatePersonList = new ArrayList<>(Arrays.asList("pobi", "honux", "crong", "jk"));
        ParticipatePeople participatePeople = ParticipatePeople.of(participatePersonList);

        assertThat(participatePeople).isEqualTo(ParticipatePeople.of(Arrays.asList("pobi", "honux", "crong", "jk")));
    }

    @DisplayName("생성한 사람의 이름이 5글자 넘을 시 Exception 테스트")
    @Test
    void validate() {
        List<String> participatePersonList = new ArrayList<>(Arrays.asList("pobi", "honux23344", "crong", "jk"));

        assertThatExceptionOfType(InvalidPersonNameException.class)
                .isThrownBy(() -> {
                    ParticipatePeople.of(participatePersonList);
                }).withMessageMatching("사람 이름이 5글자를 초과 하였습니다.");
    }
}
