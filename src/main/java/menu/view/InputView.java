package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    public static String input() {
        return readLine();
    }

    // 숫자 - 재입력
    public static int inputNumber() {
        String input = readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요.");
            return inputNumber();
        }
    }
}
