import java.util.ArrayList;

public class Pizza {
  
  public int id=0;
  public String tamanho;
  public Sabor sabor;
  public static ArrayList<Pizza> pizza = new ArrayList<Pizza>();


  public Pizza(Sabor sabor, String tamanho){
    this.id +=1;
    this.tamanho = tamanho;
    this.sabor = sabor;
    pizza.add(this);
  }

}
