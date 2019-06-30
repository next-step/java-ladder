package ladder.domain.ladder.util;

import ladder.domain.ladder.message.ErrorMessages;

import java.util.Random;

public class ConnectChooser {
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 10;
    private final static int DEFAULT_FREQUENCY = 3;
    
    private final static Random RANDOM = new Random();
    
    public static boolean shouldConnect() {
        return shouldConnect(DEFAULT_FREQUENCY);
    }
    
    public static boolean shouldConnect(int frequency) {
        if (frequency < MIN_NUMBER || frequency > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessages.OVER_RANGE.message());
        }
        
        return RANDOM.nextInt(MAX_NUMBER) > frequency;
    }
}
