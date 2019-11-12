package game.ladder.domain;

/**
 * Created by yusik on 2019/11/11.
 */
@FunctionalInterface
public interface LinkStrategy {
    boolean isLinkable();
}
