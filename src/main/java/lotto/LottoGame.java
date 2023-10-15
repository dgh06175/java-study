package lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.*;

public class LottoGame {
    private Lotto winningLotto;
    private int money;
    private List<Lotto> lottoArray;
    private LottoMachine lottoMachine;
    private LottoAnalyzer lottoAnalyzer;

    public void play() {
        inputMoney();
        //lottoMachine = new LottoMachine(money);
        //lottoArray = lottoMachine.getLottoArray();
        //inputWinningLotto();
        //lottoAnalyzer = new LottoAnalyzer(lottoArray, winningLotto);
        //printResult(lottoAnalyzer.getResult());
    }

    private void inputMoney() {
        String inputMoney = Console.readLine();
        try {
            validateInputMoney(inputMoney);
        } catch (IllegalArgumentException e) {
            // e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    private void validateInputMoney(String inputMoney) throws IllegalArgumentException {
        try {
            Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 돈 값을 입력했습니다.");
        }
    }
}
