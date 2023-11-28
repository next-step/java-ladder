package ladder.domain;

public class AlwaysTrueGenerator implements BooleanGenerator {

    @Override
    public boolean generate() {
        return true;
    }
}
