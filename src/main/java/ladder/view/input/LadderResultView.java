package ladder.view.input;

import ladder.view.View;

public class LadderResultView implements View {
    @Override
    public void render() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }
}
