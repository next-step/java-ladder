package ladder.view.result;

import ladder.view.View;

public interface FormattableView extends View {
    @Override
    default void render() {
        render(0);
    }

    void render(int formatWidth);
}
