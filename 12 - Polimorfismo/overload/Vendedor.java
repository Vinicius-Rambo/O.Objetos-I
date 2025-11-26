public class Vendedor {
    //Sobrecarga de método / Overload


    //Calcula a comissao do vendedor de acordo com regra:
    // R$ 20,00 + 5% do valor da venda 
    public float calcularComissao(float venda){
        float comissao = (venda * 0.05f) + 20.0f;
        return comissao;   
    }

    //Calcula a comissao do vendedor de acordo com a regra:
    // Percentual variável sobre o vlaor da venda
    public float calcularComissao(float venda, float perc){
        float comissao = venda * perc;
        return comissao;   
    }
    
}