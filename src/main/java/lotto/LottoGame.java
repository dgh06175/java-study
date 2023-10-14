package lotto;

import java.util.List;

public class LottoGame {
    private Lotto winningLotto;
    private int money;
    private List<Lotto> lottoArray;
    private LottoMachine lottoMachine;
    private LottoAnalyzer lottoAnalyzer;

    public void play() {
        inputMoney();
        lottoMachine = new LottoMachine(money);
        lottoArray = lottoMachine.getLottoArray();
        inputWinningLotto();
        lottoAnalyzer = new LottoAnalyzer(lottoArray, winningLotto);
        printResult(lottoAnalyzer.getResult());
    }
}
