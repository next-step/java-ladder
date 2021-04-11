package nextstep.ladder.domain;

@FunctionalInterface
public interface LineCreationStrategy {

  boolean canCreate();
}
