package ladder.Domain;


import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> row;

    private Line(List<Boolean> row) {
        this.row = row;
    }

    public static Line of(int userCount, MoveStrategy moveStrategy) {
        return new Line(createCrossLine(userCount, moveStrategy));
    }

    private static List<Boolean> createCrossLine(int userCount, MoveStrategy moveStrategy) {
        List<Boolean> crossable = new ArrayList<>();
        
        for (int i = 0; i < userCount; i++) {
            crossable.add(isCreateCrossable(crossable, moveStrategy));
        }

        return crossable;
    }
    
    private static boolean isCreateCrossable(List<Boolean> crossable, MoveStrategy moveStrategy) {
        int position = crossable.size();
        if(position >= 1 && crossable.get(position - 1)) {
            return false;
        }

        return moveStrategy.movable();
    }

    public boolean movable(int position) {
        return row.get(position);
    }
}
