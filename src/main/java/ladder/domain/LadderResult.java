package ladder.domain;

/**
 * 이름과 결과 아이템을 매핑한 정보입니다.
 * 불변 객체입니다.
 */
public class LadderResult {
    private final Name name;
    private final ResultItem item;

    public LadderResult(Name name, ResultItem item) {
        this.name = name;
        this.item = item;
    }

    public Name name() {
        return this.name;
    }

    public ResultItem resultItem() {
        return this.item;
    }
}
