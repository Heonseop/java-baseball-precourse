package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Integer> answers) {
        balls = mapToBall(answers);
    }

    private static List<Ball> mapToBall(List<Integer> answers) {
        List<baseball.Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new baseball.Ball(i + 1, answers.get(i)));
        }
        return balls;
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
