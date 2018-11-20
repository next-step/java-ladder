package domain;

import java.util.Collections;
import java.util.List;

public class ResultTagGroup {
    private List<NameTag> nameTags;

    private ResultTagGroup(List<NameTag> nameTags) {
        this.nameTags = nameTags;
    }

    public static ResultTagGroup of(List<NameTag> nameTags) {
        return new ResultTagGroup(nameTags);
    }

    public String getName(int finalPosition) {
        return nameTags.get(finalPosition).toString().trim();
    }

    public List<NameTag> getNames() {
        return Collections.unmodifiableList(nameTags);
    }
}
