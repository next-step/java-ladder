package ladder.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringSplitterTest {
    @ParameterizedTest
    @ValueSource(strings = {
            "pobi,honux,crong,jk",
            "pobi, honux, crong, jk",
            "pobi ,honux ,crong ,jk"
    })
    void split_Names_ToArray(String input) {
        final List<String> names = StringSplitter.split(input);
        assertThat(names).containsExactly("pobi",
                                          "honux",
                                          "crong",
                                          "jk");
    }
}
