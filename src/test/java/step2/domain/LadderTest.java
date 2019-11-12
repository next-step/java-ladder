package step2.domain;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    void print() {
        final BooleanGenerator booleanGenerator = new PreDefinedBooleanGenerator(Arrays.asList(
                true, false, true,
                false, true, false,
                true, false, false,
                false, true, false,
                true, false, true));

        final Ladder ladder = Ladder.builder()
                                    .maxHeight(5)
                                    .names(Arrays.asList("pobi", "honux", "crong", "jk"))
                                    .booleanGenerator(booleanGenerator)
                                    .build();

        String expected = "" +
                "  pobi honux crong    jk\n" +
                "     |-----|     |-----|\n" +
                "     |     |-----|     |\n" +
                "     |-----|     |     |\n" +
                "     |     |-----|     |\n" +
                "     |-----|     |-----|";
        String actual = ladder.print();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void print2() {
        final BooleanGenerator booleanGenerator = new PreDefinedBooleanGenerator(Arrays.asList(true));

        final Ladder ladder = Ladder.builder()
                                    .maxHeight(5)
                                    .names(Arrays.asList("one", "two"))
                                    .booleanGenerator(booleanGenerator)
                                    .build();

        String expected = "" +
                "   one   two\n" +
                "     |-----|\n" +
                "     |-----|\n" +
                "     |-----|\n" +
                "     |-----|\n" +
                "     |-----|";
        String actual = ladder.print();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void print3() {
        final BooleanGenerator booleanGenerator = new PreDefinedBooleanGenerator(Arrays.asList(true));

        final Ladder ladder = Ladder.builder()
                                    .maxHeight(5)
                                    .names(Arrays.asList("longNames", "longlongNames"))
                                    .booleanGenerator(booleanGenerator)
                                    .build();

        String expected = "" +
                " longN longl\n" +
                "     |-----|\n" +
                "     |-----|\n" +
                "     |-----|\n" +
                "     |-----|\n" +
                "     |-----|";
        String actual = ladder.print();

        assertThat(actual).isEqualTo(expected);
    }
}