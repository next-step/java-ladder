package nextstep.ladder.domain;

@FunctionalInterface
public interface HorizontalMove {
    HorizontalLocation move(Player player);
}
