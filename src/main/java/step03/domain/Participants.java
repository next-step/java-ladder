package step03.domain;

import java.util.List;

public class Participants {
    private final Names names;

    private Participants(Names names) {
        names.validateUnique();
        this.names = names;
    }

    public static Participants of(String names) {
        return new Participants(Names.of(names));
    }

    public List<String> getNames() {
        return names.getNames();
    }

    public Integer size() {
        return names.size();
    }

}
