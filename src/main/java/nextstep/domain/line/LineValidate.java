package nextstep.domain.line;

import java.util.List;

@FunctionalInterface
public interface LineValidate {

    boolean validate(List<Boolean> points);

}
