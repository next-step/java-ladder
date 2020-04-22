package ladder.domain;

import java.util.List;

public class Line {

    public Line() {
    }

    public Line(int countOfPerson) {
    }


    public boolean isLineExist(int index) {
        return index % 2 == 0 ? true : false;
    }
}
