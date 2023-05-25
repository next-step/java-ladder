package nextstep.ladder;

import java.util.Iterator;
import java.util.List;

public class Users implements Iterable<String> {
    private final List<String> users;

    public Users(List<String> users) {
        this.users = users;
    }

    @Override
    public Iterator<String> iterator() {
        return users.iterator();
    }
}
