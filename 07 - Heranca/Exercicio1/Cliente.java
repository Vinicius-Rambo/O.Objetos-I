public class Cliente extends Pessoa {
    private String produto;
    private String dataVenda;
    private int preco;
    private boolean clube;

    public Cliente(){} //Construtor.

    //Produto
    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    //Data
    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    //Preco
    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    //Clube
    public boolean isClube() {
        return clube;
    }

    public void setClube(boolean clube) {
        this.clube = clube;
    }

 
    
}
