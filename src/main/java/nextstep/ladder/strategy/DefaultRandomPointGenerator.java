package nextstep.ladder.strategy;

import java.util.Random;

public class DefaultRandomPointGenerator implements RandomPointGenerator {
    private static final int BOUND = 3;
    private static final int TARGET_NUMBER = 0;
    
    private final Random random;
    
    public DefaultRandomPointGenerator() {
        this(new Random(42));
    }
    
    public DefaultRandomPointGenerator(final Random random) {
        this.random = random;
    }
    
    @Override
    public boolean generate() {
        return random.nextInt(BOUND) == TARGET_NUMBER;
    }
} 
