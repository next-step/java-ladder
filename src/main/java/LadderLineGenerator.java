import java.util.Random;

public class LadderLineGenerator {
    
    public static final Random RANDOM = new Random();
    
    public static boolean generatePoint() {
        
        return RANDOM.nextBoolean();
    }
}
