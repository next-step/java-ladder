package ladder.domain;

import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

class LadderTest {
    private List<Name> names = new ArrayList<>();

    @BeforeEach
    void setUp() {
        names.add(new Name("harr"));
        names.add(new Name("horr"));
        names.add(new Name("hurr"));
        names.add(new Name("hirr"));
        names.add(new Name("herr"));
    }
}