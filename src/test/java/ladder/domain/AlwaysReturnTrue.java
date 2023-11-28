package ladder.domain;

public class AlwaysReturnTrue implements BooleanGenerator {

    @Override
    public boolean generate() {
        return true;
    }
}
