package nextstep.ladder.domain.ladder;

@FunctionalInterface
public interface HorizontalMove {
    HorizontalLocation move(HorizontalLocation horizontalLocation);
}
