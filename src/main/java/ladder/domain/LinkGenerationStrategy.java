package ladder.domain;

public interface LinkGenerationStrategy {
    boolean isEnableToGenerate(final boolean prevEnableToGenerate);
}
