package nextstep.domain.person;

@FunctionalInterface
public interface PersonValidate {

    boolean validate(String name);

}
