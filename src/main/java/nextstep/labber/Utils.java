package nextstep.labber;

import java.security.SecureRandom;

public class Utils {
    public static boolean randomPoint() {
        SecureRandom random = new SecureRandom();
        return random.nextBoolean();
    }
}
