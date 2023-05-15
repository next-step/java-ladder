package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class NamesTest {

    @Test
    void of() {
        Names names = Names.of("pobi,honux,crong,jk");
        Names expected = getNames();

        assertThat(names).isEqualTo(expected);
    }

    private static Names getNames() {
        List<Name> expected = new ArrayList<>();
        expected.add(Name.from("poby"));
        expected.add(Name.from("honux"));
        expected.add(Name.from("crong"));
        expected.add(Name.from("jk"));
        return new Names(expected);
    }
}
