package domain;

import java.util.List;

public interface BooleanGenerator {
    Boolean generate();
    List<Boolean> generate(int size);
}
