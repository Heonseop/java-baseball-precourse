package baseball.view;

import baseball.message.OutputMessage;
import baseball.model.PlayResult;

public class OutputView {
    public static void printResult(PlayResult playResult) {
        if (!playResult.isEndGame() && !playResult.isNothing()) {
            printBallAndStrikeMessage(playResult);
        }

        if (playResult.isEndGame()) {
            printWinningMessage(playResult);
        }
        if (playResult.isNothing()) {
            printNothingMessage();
        }
    }

    private static void printBallAndStrikeMessage(PlayResult playResult) {
        StringBuilder result = new StringBuilder();
        if (playResult.getBall() > 0) {
            addBallString(result, playResult.getBall());
        }
        if (playResult.getStrike() > 0) {
            addStrikeString(result, playResult.getStrike());
        }
        System.out.println(result);
    }

    private static void addBallString(StringBuilder result, int ball) {
        result.append(ball);
        result.append(OutputMessage.BALL);
    }

    private static void addStrikeString(StringBuilder result, int strike) {
        if (result.length() > 0) {
            result.append(" ");
        }
        result.append(strike);
        result.append(OutputMessage.STRIKE);
    }

    private static void printWinningMessage(PlayResult playResult) {
        System.out.println(playResult.getStrike() + OutputMessage.STRIKE);
        System.out.println(OutputMessage.WINNING);
    }

    private static void printNothingMessage() {
        System.out.println(OutputMessage.NOTHING);
    }
}