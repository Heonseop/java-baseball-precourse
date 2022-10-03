package baseball.view;

import baseball.message.InputMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputNumber() {
        System.out.println(InputMessage.INPUT_NUMBERS_MESSAGE);
        return Console.readLine();
    }
}
