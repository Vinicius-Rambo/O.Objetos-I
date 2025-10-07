public class Vendedor extends Funcionario{
    private float comissao;
    private float valorVenda;

    public Vendedor(){}
    
    //Valor comissão.
    public float getComissao() {
        return comissao;
    }

    public void setComissao(float comissao) {
        this.comissao = comissao;
    }

    //Valor da venda.
    public float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }
    
    
}
