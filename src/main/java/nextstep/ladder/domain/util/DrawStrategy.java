package nextstep.ladder.domain.util;

public interface DrawStrategy {

    boolean drawFirstPosition();

    boolean drawNextPosition(boolean previous);
}
