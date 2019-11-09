package ladder.domain;

public class BasicLinkGenerationStrategy implements LinkGenerationStrategy {
    @Override
    public boolean isEnableToGenerate(boolean prevEnableToGenerate) {
        if (prevEnableToGenerate) {
            return false;
        }

        return (int) (Math.random() * 10) > 3;
    }
}
