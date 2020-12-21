package ladder.domain;

import ladder.domain.utils.StringUtils;

import java.util.Objects;

public class LadderMember {
    private int pos;
    private String name;

    public LadderMember(int pos, String name){
        if (StringUtils.isNullOrBlank(name)) throw new IllegalArgumentException("사다리 참가자명은 최소 1자 이상 입력해야 합니다.");
        if (name.length() > 5) throw new IllegalArgumentException("사다리 참가자명은 최대5자 까지 입력가능합니다. (name: " + name + ")");
        this.pos = pos;
        this.name = name;
    }

    public LadderMember(String name) {
        if (StringUtils.isNullOrBlank(name)) throw new IllegalArgumentException("사다리 참가자명은 최소 1자 이상 입력해야 합니다.");
        if (name.length() > 5) throw new IllegalArgumentException("사다리 참가자명은 최대5자 까지 입력가능합니다. (name: " + name + ")");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPos() {
        return pos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderMember that = (LadderMember) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
