package view;

import controller.AlunoJpaDAO;
import model.Alunos;

public class App 
{
    public static void main( String[] args )
    {
        Alunos alunos = new Alunos();
        alunos.setNome("Jeferson");
        alunos.setEndereco("Av. Águia de Haia");
        
        AlunoJpaDAO.getInstance().merge(alunos);
        System.out.println("Objetos salvo com sucesso!!!");
    }
}
