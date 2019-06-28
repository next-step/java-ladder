package nextstep.ladder.view.impl;

import nextstep.ladder.view.InputView;

import java.util.Scanner;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-06-29 02:06
 */
public class InputViewImpl implements InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_CUSTOM_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    @Override
    public String inputCustomNames() {
        System.out.println(INPUT_CUSTOM_NAME_MESSAGE);
        return scanner.nextLine();
    }
}