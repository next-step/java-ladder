package ladder.domain;

import static ladder.domain.Point.*;

import java.util.Collections;
import java.util.List;

public class Points {
    private final List<Point> points;

    public Points(final List<Point> points) {
        this.points = points;
    }

    public int getNextLineStartIndex(final int startIndex) {
        if (isInvalidIndex(startIndex) || BLANK == points.get(startIndex)) {
            throw new IllegalArgumentException("Invalid index. index="+startIndex);
        }
        
        int pastIndex = startIndex;
        int index = startIndex;
        while(!canNotGoAnywhere(pastIndex, index)) {
            if (canOnlyGoLeft(pastIndex, index)) {
                pastIndex = index;
                index--;
            } else {
                pastIndex = index;
                index++;
            }
        }
        return index;
    }

    public List<Point> getAll() {
        return Collections.unmodifiableList(points);
    }

    public int size() {
        return points.size();
    }
    
    private boolean canNotGoAnywhere(int pastIndex, int index) {
        return !canGoLeft(pastIndex, index) && !canGoRight(pastIndex, index);
    }

    private boolean canOnlyGoLeft(int pastIndex, int index) {
        return !canGoRight(pastIndex, index) && canGoLeft(pastIndex, index);
    }
    
    private boolean canGoLeft(int pastIndex, int index) {
        return canGo(pastIndex, index - 1);
    }

    private boolean canGoRight(int pastIndex, int index) {
        return canGo(pastIndex, index + 1);
    }
    
    private boolean canGo(int pastIndex, int toIndex) {
        if (isInvalidIndex(toIndex) || pastIndex == toIndex) {
            return false;
        }
        return BLANK != points.get(toIndex);
    }
    
    private boolean isInvalidIndex(final int index) {
        return index >= points.size() || index < 0;
    }
}
