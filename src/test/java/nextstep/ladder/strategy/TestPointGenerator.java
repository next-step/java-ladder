package nextstep.ladder.strategy;

public class TestPointGenerator implements RandomPointGenerator {
    private final boolean value;
    
    public TestPointGenerator(boolean value) {
        this.value = value;
    }
    
    @Override
    public boolean generate() {
        return value;
    }
} 
