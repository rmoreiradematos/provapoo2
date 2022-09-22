import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    
    System.out.println("=== PIZZARIA DA LOHANY VEKANANDRE STEFANY SMITH BUENO DE HAHAHA RAIO-LASER BALA DE ICE KISS ===");

    System.out.println("+-----------------+");
    System.out.println("| 1 - Cadastrar Sabores  |");
    System.out.println("| 2 - Cadastrar Tamanhos |");
    System.out.println("| 3 - Cadastrar Cliente  |");
    System.out.println("| 4 - Fazer Pedido       |");
    System.out.println("| 5 - Verificar Pedido   |");
    System.out.println("| 6 - Finalizar Pedido   |");
    System.out.println("+-----------------+");

    int menu = 0;
    ArrayList<Sabor> sabores = new ArrayList<Sabor>();
    ArrayList<String> tamanhos = new ArrayList<String>();
    ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    ArrayList<Comanda> comandas = new ArrayList<Comanda>();
    Scanner scanner = new Scanner(System.in);
    int numeroPedido = 0;
    try {
        menu = scanner.nextInt();
    } catch (Exception e) {
        System.err.println(e.getMessage());
        menu = 0;
    }
    do {
      
      switch (menu) {
          case 1:  
            System.out.println("Por gentileza, quantos sabores queres cadastrar?");
            Scanner scanQuantidade = new Scanner(System.in);
            int quantidade = scanQuantidade.nextInt();
            for(int i = 0; i < quantidade; i++){
              System.out.println("Digite a descrição da pizza");
              Scanner scanDescricao = new Scanner(System.in);
              String descricaoPizza = scanDescricao.next();
              System.out.println("Digite o detalhamento dos ingredientes do sabor");
              Scanner scanDetalhamento = new Scanner(System.in).useDelimiter("\n");
              String detalhamentoPizza = scanDetalhamento.next();
              if (sabores.isEmpty()){
                Sabor sabor = new Sabor(i, descricaoPizza, detalhamentoPizza);
                sabores.add(sabor);
              }else{
                int novoId = sabores.get(sabores.size() - 1).id+1;
                Sabor sabor = new Sabor(novoId, descricaoPizza, detalhamentoPizza);
                sabores.add(sabor);
              }
            }
            break;
          case 2:
            Boolean cadastrando = true;
            do{
              System.out.println("Por gentileza, cadastre os tamanhos das pizzas P, M, G ou GG");
              Scanner scanTamanho = new Scanner(System.in);
              String tamanhoPizza = scanTamanho.next();
              if(tamanhoPizza.equals("P") || tamanhoPizza.equals("M") || tamanhoPizza.equals("G") || tamanhoPizza.equals("GG")){
                tamanhos.add(tamanhoPizza);
              }
              else{
                System.out.println("Tamanho inválido");
              }
              System.out.println("queres cadastrar mais um tamanho? [S/N]?");
              Scanner scanOpcao = new Scanner(System.in);
              String scanCadastro = scanOpcao.next();
              cadastrando =  scanCadastro.equals("S") ? true: false;
            }while(cadastrando);
            break;
          case 3:
              System.out.println("Digite o seu cpf");
              Scanner scanCPF = new Scanner(System.in);
              String cpf = scanCPF.next();
              System.out.println("Digite o seu telefone");
              Scanner scanTelefone = new Scanner(System.in).useDelimiter("\n");
              String telefone = scanTelefone.next();
              System.out.println("Digite o seu endereco");
              Scanner scanEndereco = new Scanner(System.in).useDelimiter("\n");
              String endereco = scanEndereco.next();
              Cliente cliente = new Cliente(cpf, telefone, endereco);
              clientes.add(cliente);
              break;
          case 4:
              System.out.println("Digite a data de hoje");  
              Scanner scanData = new Scanner(System.in);
              String data = scanData.next();
              String tamanhoEscolhido;
              ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
              System.out.println("Quantas pizzas queres na comanda?");
              Scanner scanQuantidadePizzas = new Scanner(System.in);
              int quantidadePizzas = scanQuantidadePizzas.nextInt();
              for(int i = 0; i<quantidadePizzas; i++){
                System.out.println("Selecione o tamanho da Pizza");
                for(String tamanho : tamanhos){
                  System.out.println(tamanho);
                }
                Scanner scanPizza = new Scanner(System.in);
                tamanhoEscolhido = scanPizza.next();
                StringBuilder stringSabores = new StringBuilder();
                for(Sabor sabor : sabores){
                  stringSabores.append("Digite " + sabor.id + " - " + sabor.descricao + " - " + sabor.detalhamento);
                  stringSabores.append("\n");
                }
                System.out.println(stringSabores.toString());
                Scanner scanSabor = new Scanner(System.in);
                int saborPizza = scanSabor.nextInt();
                for(Sabor sabor : sabores){
                  if(sabor.id == saborPizza){
                    Pizza pizza = new Pizza(sabor, tamanhoEscolhido);
                    pizzas.add(pizza);
                  }
                }
              }

              Comanda comanda = new Comanda(clientes.get(0), pizzas, numeroPedido, data);
              comandas.add(comanda);
              numeroPedido+=1;
              System.out.println("Pedido realizado com sucesso, sua comanda é: " + comanda.numero);
              break;
          
          case 5:
              System.out.println("Digite o número do seu pedido");
                Scanner scanComanda = new Scanner(System.in);
                int numeroComanda = scanComanda.nextInt();
              for(Comanda comandaFinalizada : comandas){
                comandaFinalizada.listarComanda(numeroComanda);
              }
              break;
          // // Lista Extra
          case 6:
              scanner.close();
              break;
          default:
              System.out.println("Operação inválida");
              break;
      }
      System.out.println("+-----------------+");
      System.out.println("| 1 - Cadastrar Sabores  |");
      System.out.println("| 2 - Cadastrar Tamanhos |");
      System.out.println("| 3 - Cadastrar Cliente  |");
      System.out.println("| 4 - Fazer Pedido       |");
      System.out.println("| 5 - Verificar Pedido   |");
      System.out.println("| 6 - Finalizar Pedido   |");
      System.out.println("+-----------------+");
      menu = scanner.nextInt();
    }while(menu != 6);
  }
}
