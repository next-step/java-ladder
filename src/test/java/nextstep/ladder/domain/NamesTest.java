package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NamesTest {

    @Test
    @DisplayName("성공 - 참가자들이 생성된다.")
    void success_generate_participants() {
        List<String> persons = List.of("pobi", "honux", "crong", "jk");

        Names participants = new Names(persons);

        assertThat(participants.countOfParticipant()).isEqualTo(4);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:pobi", "1:honux", "2:crong", "3:jk"}, delimiter = ':')
    @DisplayName("성공 - 인덱스에 해당하는 이름을 구한다.")
    void success_find_name(int index, String person) {
        List<String> persons = List.of("pobi", "honux", "crong", "jk");

        Names participants = new Names(persons);

        assertThat(participants.name(index)).isEqualTo(new Name(person));
    }

}
