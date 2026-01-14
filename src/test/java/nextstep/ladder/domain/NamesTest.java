package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NamesTest {

    @Test
    void create_names_from_string() {
        String input = "kim,lee,pobi";
        assertThat(new Names(input).getValues()).hasSize(3);
    }

    @Test
    void create_names_from_list() {
        List<Name> input = List.of(new Name("kim"), new Name("park"));
        assertThat(new Names(input).getValues()).hasSize(2);
    }
}