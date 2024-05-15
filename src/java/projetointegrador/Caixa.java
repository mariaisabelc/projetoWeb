package projetointegrador;
import java.util.ArrayList;
import java.util.List;

public class Caixa {
    private List<Venda> vendas;

    public Caixa() {
        this.vendas = new ArrayList<>();
    }

    public void adicionarVenda(Venda venda) {
        vendas.add(venda);
    }

    public List<Venda> obterVendas() {
        return vendas;
    }
}
