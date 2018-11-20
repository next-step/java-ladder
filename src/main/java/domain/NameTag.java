package domain;

import com.google.common.base.Objects;
import utils.StringUtils;

public class NameTag {
    private static final int NAME_LENGTH_LIMIT = 5;
    private String name;

    private NameTag(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new RuntimeException("글자수를 초과했습니다.");
        }
        this.name = name;
    }

    public static NameTag of(String name) {
        return new NameTag(name);
    }

    @Override
    public String toString() {
        String str = StringUtils.getReplace(StringUtils.SPACE, NAME_LENGTH_LIMIT + 1);
        StringBuilder sb = new StringBuilder(str);
        sb.replace(0, name.length(), name);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NameTag)) return false;
        NameTag nameTag = (NameTag) o;
        return Objects.equal(name, nameTag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
