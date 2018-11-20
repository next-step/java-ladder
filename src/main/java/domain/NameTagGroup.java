package domain;

import java.util.List;

public class NameTagGroup {
    List<NameTag> nameTags;

    private NameTagGroup(List<NameTag> nameTags) {
        this.nameTags = nameTags;
    }

    public static NameTagGroup of(List<NameTag> makeNameTag) {
        return new NameTagGroup(makeNameTag);
    }
}
