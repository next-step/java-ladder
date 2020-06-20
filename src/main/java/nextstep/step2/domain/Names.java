package nextstep.step2.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Names {
    private static final String NAME_SEPARATOR = ",";
    private List<Name> names = new ArrayList<>();

    public Names(String names) {
        String[] nameArray = names.split(NAME_SEPARATOR);
        List<String> nameList = Arrays.asList(nameArray);
        nameList.forEach(name -> this.names.add(new Name(name)));
    }

    public int getParticipantsCount() {
        return names.size();
    }

    public List<Name> getNames() {
        return names;
    }

}
