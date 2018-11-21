package domain;

import java.util.Collections;
import java.util.List;

public class NameTagGroup {
    List<NameTag> nameTags;
    Ladder ladder;

    private NameTagGroup(List<NameTag> nameTags, Ladder ladder) {
        if (nameTags.stream().distinct().count() != nameTags.size()) {
            throw new IllegalArgumentException("중복이름은 올 수 없습니다.");
        }
        this.nameTags = nameTags;
        this.ladder = ladder;
    }

//    public static NameTagGroup of(List<NameTag> makeNameTag, int height) {
//        return new NameTagGroup(makeNameTag, Ladder.of(makeNameTag.size(), height));
//    }
//
//    public static NameTagGroup ofLadder(List<NameTag> nameTags, Ladder ladder) {
//        return new NameTagGroup(nameTags, ladder);
//    }

    public static NameTagGroup ofDifficult(List<NameTag> makeNameTag, Difficult difficult) {
        return new NameTagGroup(makeNameTag, Ladder.ofDifficult(makeNameTag.size(), difficult));
    }

    public int size() {
        return nameTags.size();
    }

    public int indexOf(String name) {
        NameTag nameTag = NameTag.of(name);
        int index = nameTags.indexOf(nameTag);
        if (index < 0) {
            throw new IllegalArgumentException("배열에 존재하지 않습니다.");
        }
        return index;
    }

    public String getName(int position) {
        return nameTags.get(position).toString().trim();
    }

    public int getFinalPosition(int index) {
        return ladder.getFinalPosition(index);
    }

    public List<NameTag> getNames() {
        return Collections.unmodifiableList(nameTags);
    }

    public List<LadderLine> viewLadder() {
        return ladder.getLadderMap();
    }

}
