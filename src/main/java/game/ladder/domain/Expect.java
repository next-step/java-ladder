package game.ladder.domain;

import spark.utils.Assert;
import spark.utils.StringUtils;

public class Expect {

    public static final String FORMAT = "%6s";
    private final String value;

    public Expect(String value) {
        Assert.isTrue(StringUtils.isNotBlank(value), "1글자 이상의 값을 입력해 주세요.");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String formattedValue() {
        return String.format(FORMAT, this.value);
    }

}
