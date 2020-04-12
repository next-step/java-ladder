package ladder.drawable;

import java.util.Random;

public class RandomDraw implements Drawable{

    @Override
    public boolean canDraw() {
        return new Random().nextInt(10) < 4;
    }
}
