package nextstep.ladder.domain;

@FunctionalInterface
public interface LadderCreator {

    Ladder create(final PositiveNumber ladderHeight, final PositiveNumber ladderWidth);

}
