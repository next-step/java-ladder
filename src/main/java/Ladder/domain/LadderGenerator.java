package Ladder.domain;

@FunctionalInterface
public interface LadderGenerator {
    Ladder generate(final int peopleNumber, final int height);
}
