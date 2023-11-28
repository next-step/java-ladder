package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParticipatorsTest {

    @DisplayName("이름 목록을 전달받으면 Participator 리스트를 만들어줍니다.")
    @Test
    void makeParticipators() {
        // given
        List<String> names = List.of("pobi", "honux", "crong", "jk");
        // when
        Participators result = Participators.from(names);
        // then
        Assertions.assertThat(result.getParticipators()).hasSize(4);
    }

    @DisplayName("참가자가 몇 명인지 전달해줍니다.")
    @Test
    void count() {
        // given
        List<String> names = List.of("pobi", "honux", "crong", "jk");
        Participators participators = Participators.from(names);
        // when
        int result = participators.participatorCount();
        // then
        Assertions.assertThat(result).isEqualTo(4);
    }

}