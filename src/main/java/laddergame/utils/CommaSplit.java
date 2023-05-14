package laddergame.utils;

public class CommaSplit {

    private static final String DELIMITER = ",";

    private CommaSplit(){}

    public static String[] of(String str){
        return str.split(DELIMITER);
    }
}
