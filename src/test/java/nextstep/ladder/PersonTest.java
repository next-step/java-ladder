package nextstep.ladder;

import nextstep.ladder.domain.Person;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PersonTest {

    @DisplayName("참가자는 이름을 갖는다")
    @Test
    void name() {
        Assertions.assertThat(new Person("현구막")).isEqualTo(new Person("현구막"));
    }

}
