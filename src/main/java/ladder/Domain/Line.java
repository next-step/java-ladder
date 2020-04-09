package ladder.Domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Boolean> row;

    private Line(int userCount, CrossRoadStrategy crossRoadStrategy) {
        this.row = createCrossLine(userCount, crossRoadStrategy);
    }

    public static Line of(int userCount, CrossRoadStrategy crossRoadStrategy) {
        return new Line(userCount, crossRoadStrategy);
    }

    private List<Boolean> createCrossLine(int userCount, CrossRoadStrategy crossRoadStrategy) {
        List<Boolean> crossable = new ArrayList<>();
        
        for (int i = 0; i < userCount; i++) {
            crossable.add(isCreateCrossable(crossable, crossRoadStrategy));
        }

        return crossable;
    }
    
    private boolean isCreateCrossable(List<Boolean> crossable, CrossRoadStrategy crossRoadStrategy) {
        int position = crossable.size();
        if(position >= 1 && crossable.get(position - 1)) {
            return false;
        }

        return crossRoadStrategy.movable();
    }

    public boolean movable(int position) {
        return row.get(position);
    }

    public List<Boolean> toList() {
        return Collections.unmodifiableList(row);
    }

    @Override
    public boolean equals(Object obj) {
        Line compareLine = (Line) obj;
        System.out.println(compareLine.row.toString());
        System.out.println(this.row.toString());

        return this.row.toString().equals(compareLine.row.toString());
    }
}
