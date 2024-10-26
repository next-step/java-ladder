package nextstep.ladder.domain.direction;

@FunctionalInterface
public interface LineGenerator {

    boolean generate(boolean before);
}
