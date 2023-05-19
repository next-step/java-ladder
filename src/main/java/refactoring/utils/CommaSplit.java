package refactoring.utils;

public class CommaSplit {

    private static final String DELIMITER = ",";

    private CommaSplit(){}

    public static String[] split(final String str) {
       return str.split(DELIMITER);
    }
}
