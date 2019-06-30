package nextstep.step2.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-06-29 02:15
 */
public class Custom {

    private List<Name> names;

    /*
     궁금증 1)

     생성자 public으로 열어서 객체화 가능하게 하는것과
     아래의 정적팩토리의 of메서드를 인자값 type만 다르게 하여 사용가능하게 2가지 생성방식을 사용하는것에데해 괜찮은 방법일까요?
      */
    public Custom(List<Name> names) {
        this.names = names;
    }

    public static Custom of(List<String> names) {
        if (names.size() == 0) {
            throw new IllegalArgumentException("사람이 입력되지 않았습니다.");
        }
        return new Custom(names.stream()
                .distinct()
                .filter(name -> !"".equals(name))
                .map(name -> Name.of(name.trim()))
                .collect(Collectors.toList()));
    }

    public int count() {
        return names.size();
    }

    public boolean hasCustom(Name name) {
        return names.stream()
                .filter(sourceName -> sourceName.isName(name))
                .findFirst()
                .isPresent();
    }

    public Stream<Name> stream() {
        return names.stream();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
