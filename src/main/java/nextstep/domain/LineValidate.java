package nextstep.domain;

import java.util.List;

@FunctionalInterface
public interface LineValidate {

    boolean validate(List<Boolean> points);

}
