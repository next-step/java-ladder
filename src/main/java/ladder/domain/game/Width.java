package ladder.domain.game;

import com.sun.org.apache.xerces.internal.util.EntityResolverWrapper;

import java.util.List;

/**
 * Created By mand2 on 2020-12-11.
 */
public class Width {
    private final int width;

    private Width(int width) {
        this.width = width;
    }

    public static Width from(int width) {
        return new Width(width);
    }

    public static Width from(List<Line> ladder) {
        return new Width(ladder.get(0).getLine().size());
    }

    public int getWidth() {
        return width;
    }
}
