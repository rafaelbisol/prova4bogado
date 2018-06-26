
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utfpr.ct.dainf.pratica.Lancamento;
import utfpr.ct.dainf.pratica.ProcessaLancamentos;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author Bisol
 */
public class Pratica {
 
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        String caminho;
        ProcessaLancamentos lancamento;
        List<Lancamento> lancamentos = new ArrayList<>();
        Integer conta;
        
        System.out.println("Digite o caminho completo para o arquivo: ");
        caminho = scanner.next();
        
        lancamento = new ProcessaLancamentos(caminho);
        lancamentos = lancamento.getLancamentos();
        
             
        do{
            System.out.println("Digite o número da conta (Digite 0 para parar): ");
            
            while(scanner.hasNextInt()==false)
                System.out.println("Por favor, digite um valor numérico\n");
            
                
        
            conta = scanner.nextInt();
            
            if(conta!=0)
                if(lancamentos.indexOf(conta)>-1)
                    exibeLancamentosConta(lancamentos, conta);
                else
                    System.out.println("Conta Inexistente\n");
        } while(conta != 0);        
    }
    
    public static void exibeLancamentosConta(List<Lancamento> lancamentos, Integer conta) {
        int primeira_ocorrencia = lancamentos.indexOf(conta);
        int ultima_ocorrencia = lancamentos.lastIndexOf(conta);
        
        while(primeira_ocorrencia<=ultima_ocorrencia) {
            lancamentos.get(primeira_ocorrencia).toString();
            primeira_ocorrencia++;
        }
    }
   
}