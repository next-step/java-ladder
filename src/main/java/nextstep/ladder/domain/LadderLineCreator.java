package nextstep.ladder.domain;

@FunctionalInterface
public interface LadderLineCreator {

    LadderLine create(final PositiveNumber pointsSize);

}
