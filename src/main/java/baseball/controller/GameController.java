package baseball.controller;

import baseball.model.Balls;
import baseball.util.RandomUtils;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private static final int SIZE = 3;
    private static final int START_NUM = 1;
    private static final int END_NUM = 9;
    private boolean isEnd = true;

    public GameController() {

    }

    public void startGame() {
        Balls computer = new Balls(RandomUtils.getRandomNumbers(SIZE, START_NUM, END_NUM));
        while (isEnd) {
            String input = InputView.inputNumber();
            Balls user = new Balls(input);
            OutputView.printResult(computer.play(user));
            isEnd = false;
        }
    }
}
