package my.project.step3.util;

import java.util.Scanner;

/**
 * Created : 2020-12-04 오전 8:54
 * Developer : Seo
 */
public class Scan {
    static Scanner instance;

    private Scan() {
    }

    public static Scanner getInstance() {
        if (instance == null) {
            instance = new Scanner(System.in);
        }
        return instance;
    }

}
