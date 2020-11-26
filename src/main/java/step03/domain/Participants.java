package step03.domain;

import java.util.List;

public class Participants {
    private static final String ALL = "all";
    private final Names names;

    private Participants(Names names) {
        names.validateUnique();
        names.validateProhibitNames(ALL);
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

    public Integer indexOf(String name) {
        return names.indexOf(name);
    }


}
