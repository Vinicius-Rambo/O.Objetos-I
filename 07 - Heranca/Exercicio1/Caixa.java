public class Caixa {
    private String numCaixa;
    private String loginPDV;
    private String senhaPDV;

    public Caixa(){}

    //Numero da caixa
    public String getNumCaixa() {
        return numCaixa;
    }
    public void setNumCaixa(String numCaixa) {
        this.numCaixa = numCaixa;
    }

    //Login PDV
    public String getLoginPDV() {
        return loginPDV;
    }
    public void setLoginPDV(String loginPDV) {
        this.loginPDV = loginPDV;
    }

    //Senha PDV
    public String getSenhaPDV() {
        return senhaPDV;
    }
    public void setSenhaPDV(String senhaPDV) {
        this.senhaPDV = senhaPDV;
    }
}

