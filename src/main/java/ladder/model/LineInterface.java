package ladder.model;

import ladder.model.utils.ConnectLine;

import java.util.List;

public interface LineInterface {
    List<Boolean> getPoints();
    void checkValidConnect(List<Boolean> points);

    static boolean connectLine(boolean before, ConnectLine connectLine) {
        return true;
    }
}
