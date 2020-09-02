package nextstep.mission.lib;

public class StringUtils {

    /**
     * null 이거나 빈문자 여부를 판별합니다.
     *
     * @param value
     * @return
     */
    public static boolean isBlank(String value) {
        if (value == null || value.trim().length() == 0) {
            return true;
        }

        return false;
    }
}
