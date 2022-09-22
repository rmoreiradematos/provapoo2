import java.util.ArrayList;

public class Sabor {
  public int id;
  public String descricao;
  public String detalhamento;
  public static ArrayList<Sabor> sabores = new ArrayList<Sabor>();
  

  public Sabor(int id, String descricao, String detalhamento){
    this.id = id;
    this.descricao = descricao;
    this.detalhamento = detalhamento;
    sabores.add(this);
  }
  public void listarSabores(){
    for(Sabor sabor : sabores){
      System.out.println("ID: " + sabor.id);
      System.out.println("Descrição: " + sabor.descricao);
      System.out.println("Detalhamento: " + sabor.detalhamento);
    }
  }

  public Sabor buscarSabor(int id){
    for(Sabor sabor : sabores){
      if(sabor.id == id){
        return sabor;
      }
    }
    return null;
  }
}
