package nextstep.entity;

import java.util.List;

public class Entries {

    private final List<Entry> entries;

    public Entries(List<Entry> entries) {
        this.entries = entries;
    }

    public int getPersonnel() {
        return entries.size();
    }
}
