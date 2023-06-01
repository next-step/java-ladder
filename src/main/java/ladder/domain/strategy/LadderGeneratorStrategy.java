package ladder.domain.strategy;

public interface LadderGeneratorStrategy {

    Boolean isBuild();

    Boolean isBuild(int variable);
}
