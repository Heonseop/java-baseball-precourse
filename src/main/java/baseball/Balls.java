package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Integer> answers) {
        if (isNotValidSize(answers)) {
            throw new IllegalArgumentException();
        }
        if (isDuplicateNumbers(answers)) {
            throw new IllegalArgumentException();
        }
        balls = mapToBall(answers);
    }

    private boolean isDuplicateNumbers(List<Integer> answers) {
        HashSet<Integer> result = new HashSet<>(answers);
        return result.size() < 3;
    }

    private boolean isNotValidSize(List<Integer> answers) {
        return answers.isEmpty() || answers.size() > 3;
    }

    private static List<Ball> mapToBall(List<Integer> answers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, answers.get(i)));
        }
        return balls;
    }

    public PlayResult play(List<Integer> userNums) {
        Balls userBalls = new Balls(userNums);
        PlayResult result = new PlayResult();
        for (Ball answer : balls) {
            BallStatus status = userBalls.play(answer);
            result.setResult(status);
        }
        return result;
    }

    public BallStatus play(Ball userBall) {
        // TODO : depth 1로 변경
        for (Ball ball : balls) {
            BallStatus checkBall = ball.play(userBall);
            if (checkBall.isNotNothing()) {
                return checkBall;
            }
        }
        return BallStatus.NOTHING;
    }
}
