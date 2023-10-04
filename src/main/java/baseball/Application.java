package baseball;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    static boolean isContinue = true;
    // 재시작 로직 어떻게 짜지 ?
    static ArrayList<String> computerNumber = ArrayList<>(Arrays.asList("0", "0", "0"));
    // 컴퓨터 숫자 정수로 할까 문자열로 할까 문자 배열로 할까?

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (isContinue) {
            initComputerNumber();
            gameStart();
            inputGameContinue();
        }
    }

    private static void initComputerNumber() {
        for (int i = 0; i < computerNumber.length; i++) {
            computerNumber[i] = (char)(int)(Math.random() * 9 + 1);
        }
        System.out.println(computerNumber);
    }

    private static boolean gameStart() {
        return false;
    }
}
