package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PartIndexTest {

    private List<Parts> lines;

    @BeforeEach
    void setUp() {
        final int length = 3;
        lines = new ArrayList<>();
        lines.add(new Parts(length));
        lines.add(new Parts(length));
    }

    @Test
    void createTest() {
        PartIndex partIndex = new PartIndex(0, 0);

        Part part = partIndex.partOf(lines);

        assertThat(part.isHorizontalLine()).isFalse();
    }

}