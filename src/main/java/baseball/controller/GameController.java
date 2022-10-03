package baseball.controller;

import baseball.model.Balls;
import baseball.model.Game;
import baseball.model.GameStatus;
import baseball.util.RandomUtils;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private static final int SIZE = 3;
    private static final int START_NUM = 1;
    private static final int END_NUM = 9;

    public GameController() {

    }

    public void initGame() {
        Game game = new Game();
        while (!game.isFinishGame()) {
            startGame(game);
        }
    }

    public void startGame(Game game) {
        game.setGameStatus(GameStatus.START);
        game.setComputer(new Balls(RandomUtils.getRandomNumbers(SIZE, START_NUM, END_NUM)));
        while (!game.isEndGame()) {
            playGame(game);
        }
        checkRestart(game);
    }

    private void playGame(Game game) {
        String inputNumbers = InputView.inputNumber();
        game.setUser(new Balls(inputNumbers));
        game.playGame();
        OutputView.printResult(game.getPlayResult());
    }

    private void checkRestart(Game game) {
        String inputRestartInfo = InputView.inputRestartOrFinish();
        game.checkFinish(inputRestartInfo);
    }
}
