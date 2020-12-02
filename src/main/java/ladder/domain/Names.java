package ladder.domain;

import ladder.util.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Names {
    private static int MAX_NAME_LENGTH = 5;

    private List<String> names = new ArrayList<>();

    public Names(final String names) {
        initNames(names);
    }

    private void initNames(final String names) {
        List<String> tempNames = Arrays.asList(names.replaceAll(" ", "").split(","));

        checkName(tempNames);

        this.names = tempNames;
    }

    private void checkName(final List<String> tempNames) {
        isEmpty(tempNames);

        for (String name : tempNames) {
            checkNameLength(name);
        }
    }

    private void isEmpty(final List<String> tempNames){
        if(tempNames.size() == 0){
            throw new RuntimeException(ErrorMessage.getCheckInputNames());
        }
    }

    private void checkNameLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new RuntimeException(ErrorMessage.getCheckNameLength());
        }
    }

    public List<String> getNames() {
        return names;
    }
}
