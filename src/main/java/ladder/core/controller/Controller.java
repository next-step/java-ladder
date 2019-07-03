package ladder.core.controller;

import ladder.core.message.Request;

public interface Controller {
    void action();
    void input(Request data);
}
