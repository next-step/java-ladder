package step4.domain.column;

import java.util.Arrays;
import java.util.List;
import step4.exceptions.NotEqualColumnSizeException;
import step4.exceptions.UserNumberException;

public class LadderColumn {

    List<String> names;

    public LadderColumn(String names) {

        this.names = Arrays.asList(names.split(","));
        if (this.names.size() < 2) {
            throw new UserNumberException();
        }
    }

    public String name(int index) {
        return names.get(index);
    }

    public int sizeOfPerson() {
        return names.size();
    }

    public List<String> names() {
        return names;
    }

    public void matchSize(LadderColumn ladderColumn) {
        if (names.size() != ladderColumn.names.size()) {
            throw new NotEqualColumnSizeException();
        }
    }

    public int index(String target) {
        return names.indexOf(target);
    }
}
