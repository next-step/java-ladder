package laddergame.utils;

public class Split {

    private static final String DELIMITER = ",";

    private Split(){}

    public static String[] of(String str){
        return str.split(DELIMITER);
    }
}
