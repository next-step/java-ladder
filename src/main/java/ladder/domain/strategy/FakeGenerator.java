package ladder.domain.strategy;

public class FakeGenerator implements GeneratorInterface {
    @Override
    public boolean generate() {
        return false;
    }
}
