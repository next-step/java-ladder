package step02.user;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private final static String REGEX = ",";
    private final List<Name> names;

    public Users(String names) {
        this.names = splitName(names);
    }

    public static List<Name> splitName(String names) {
        return Arrays.stream(names.split(REGEX))
                .map(Name::new).collect(Collectors.toList());
    }

    public int getUserCount() {
        return names.size();
    }

    public List<Name> getUserNames() {
        return names;
    }

}
