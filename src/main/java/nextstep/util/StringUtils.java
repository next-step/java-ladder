package nextstep.util;

public class StringUtils {

    public static String lpad(String name, int maxLength) {

        int length = name.length();

        if (length > maxLength) {
            throw new IllegalArgumentException("사람 이름을 5자를 넘지 못합니다.");
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= maxLength - name.length(); i++) {
            sb.append(" ");
        }
        return sb.toString() + name;
    }
}
