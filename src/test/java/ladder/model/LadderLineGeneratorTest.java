package ladder.model;

import java.lang.reflect.Method;
import java.util.List;

public class LadderLineGeneratorTest {
    public static final LadderLinesGenerator ladderLinesGenerator = new NarrowLadderLinesGenerator();
    public static Method generatePointsMethod;

    private static final String METHOD_NAME_FOR_GENERATING_POINTS = "generatePoints";

    static {
        try {
            generatePointsMethod = LadderLinesGenerator.class.getDeclaredMethod(METHOD_NAME_FOR_GENERATING_POINTS, List.class);
            generatePointsMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
