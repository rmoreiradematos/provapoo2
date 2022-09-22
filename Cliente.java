import java.util.ArrayList;

public class Cliente{

  public int id = 1;
  public String cpf;
  public String telefone;
  public String endereco;
  public static ArrayList<Cliente> cliente = new ArrayList<Cliente>();


  public Cliente(String cpf, String telefone, String endereco){
    this.id +=1;
    this.cpf = cpf;
    this.telefone = telefone;
    this.endereco = endereco;
    cliente.add(this);
  }

  public void listarClientes(){
    for(Cliente c : cliente){
      System.out.println("ID: " + c.id);
      System.out.println("CPF: " + c.cpf);
      System.out.println("Telefone: " + c.telefone);
      System.out.println("Endereço: " + c.endereco);
    }
  }
}