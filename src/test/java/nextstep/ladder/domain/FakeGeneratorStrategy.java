package nextstep.ladder.domain;

public class FakeGeneratorStrategy implements GeneratorStrategy {
    private final boolean value;

    public FakeGeneratorStrategy(boolean value) {
        this.value = value;
    }

    @Override
    public boolean isGenerate() {
        return value;
    }
}
