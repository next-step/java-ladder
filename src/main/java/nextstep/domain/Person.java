package nextstep.domain;

public class Person {

    public static boolean validateName(String name) {
        if(StringUtils.isNullOrEmpty(name)) {
            return false;
        }
        if(name.length() > 5) {
            return false;
        }
        return true;
    }

}
