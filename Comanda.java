import java.util.ArrayList;

public class Comanda {
  
  public int id=0;
  public int numero;
  public String data;
  public Cliente cliente;
  public ArrayList<Pizza> pizzas;
  public static ArrayList<Comanda> comandas = new ArrayList<Comanda>();


  public Comanda(Cliente cliente, ArrayList<Pizza> pizza, int numero, String data){
    this.id +=1;
    this.cliente = cliente;
    this.pizzas = pizza;
    this.numero = numero;
    this.data = data;
    comandas.add(this);
  }

  public void listarComanda(int numero){

    if(comandas.size() == 0){
      System.out.println("Não há comandas cadastradas");
    }else{
      for(Comanda comanda : comandas){
        if(comanda.numero == numero){
          System.out.println("Número da comanda: " + comanda.numero);
          System.out.println("Data: " + comanda.data);
          System.out.println("Cliente: " + comanda.cliente.id);
          System.out.println("Pizzas: ");
          for(Pizza pizza : comanda.pizzas){
            System.out.println("Sabor: " + pizza.sabor.descricao);
            System.out.println("Tamanho: " + pizza.tamanho);
          }
        }
      }
    }
  }
}
