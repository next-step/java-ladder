package nextstep.ladder.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class PeopleTest {

    @Test
    void 사람_이름은_쉼표로_구분한다() throws Exception {
        // given
        String names = "a,b,c,d";

        // when
        People people = new People(names);

        // then
        assertThat(people.people().size()).isEqualTo(4);
    }

}
