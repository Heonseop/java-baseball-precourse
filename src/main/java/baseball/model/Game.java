package baseball.model;

import baseball.validator.InputFinishValidator;

public class Game {
    GameStatus gameStatus;
    Balls computer;
    Balls user;
    PlayResult playResult;

    public Game() {
        gameStatus = GameStatus.INIT;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public boolean isEndGame() {
        return this.gameStatus == GameStatus.END;
    }

    public boolean isFinishGame() {
        return this.gameStatus == GameStatus.FINISH;
    }

    public void setComputer(Balls computer) {
        this.computer = computer;
    }

    public void setUser(Balls user) {
        this.user = user;
    }

    public PlayResult getPlayResult() {
        return playResult;
    }

    public void playGame() {
        if (gameStatus != GameStatus.PLAY) {
            gameStatus = GameStatus.PLAY;
        }
        playResult = computer.play(user);
        if (playResult.isEndGame()) {
            this.setGameStatus(GameStatus.END);
        }
    }

    public void checkFinish(String inputFinishInfo) {
        InputFinishValidator inputFinishValidator = new InputFinishValidator(1, 2, 1);
        if (inputFinishValidator.isInputValidate(inputFinishInfo)
                && Integer.parseInt(inputFinishInfo) == GameStatus.FINISH.ordinal()) {
            gameStatus = GameStatus.FINISH;
        }
    }
}
