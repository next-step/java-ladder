package game.ladder.domain;

import java.util.Random;

/**
 * Created by yusik on 2019/11/14.
 */
public class RandomLinkStrategy implements LinkStrategy {

    private Random random = new Random();

    @Override
    public boolean isLinkable() {
        return random.nextBoolean();
    }
}
