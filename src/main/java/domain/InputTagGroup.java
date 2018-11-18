package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputTagGroup {
    private List<NameTag> nameTags;
    private Ladder ladder;


    private InputTagGroup(List<NameTag> nameTags, Ladder ladder) {
        if (nameTags.stream().distinct().count() != nameTags.size()) {
            throw new IllegalArgumentException("중복");
        }
        this.nameTags = nameTags;
        this.ladder = ladder;
    }

    public static InputTagGroup of(List<NameTag> nameTags, Ladder ladder) {
        return new InputTagGroup(nameTags, ladder);
    }

    public List<String> getAllFinalResult(ResultTagGroup resultTagGroups) {
        List<String> stringList = new ArrayList<>();

        for (NameTag nameTag : nameTags) {
            int finalPosition = ladder.getFinalPosition(indexOf(nameTag));
            stringList.add(nameTag.toString() + " : " + resultTagGroups.getName(finalPosition));
        }
        return stringList;
    }

    public int indexOf(NameTag name) {
        return nameTags.indexOf(name);
    }

    public String getFinalResult(String name, ResultTagGroup resultTagGroup) {
        NameTag nameTag = NameTag.of(name);
        if (!nameTags.contains(nameTag)) {
            throw new IllegalArgumentException("해당 이름이 없습니다.");
        }

        int finalPosition = ladder.getFinalPosition(indexOf(nameTag));
        return resultTagGroup.getName(finalPosition);
    }

    public List<NameTag> getNameTags() {
        return Collections.unmodifiableList(nameTags);
    }
}
