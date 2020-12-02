package step04.utils;

import org.omg.CORBA.Any;

import java.security.AllPermission;
import java.util.List;

public class Validator {

    private Validator() {};

    public static <T> boolean isUnique(List<T> list) {
        return list.stream().distinct().count() == list.size();
    }
}