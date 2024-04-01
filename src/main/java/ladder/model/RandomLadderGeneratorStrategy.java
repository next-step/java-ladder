package ladder.model;

public class RandomLadderGeneratorStrategy implements LadderGeneratorStrategy {

    @Override
    public boolean generate() {
        return RandomBooleanGenerator.generate();
    }

}
