package utfpr.ct.dainf.pratica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static java.util.Collections.sort;

/**
 * Linguagem Java
 * @author Bisol
 */
public class ProcessaLancamentos {
    private BufferedReader reader;

    public ProcessaLancamentos(File arquivo) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(arquivo));
    }

    public ProcessaLancamentos(String path) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(path));
        System.out.println("Abriu");
    }
    
    private String getNextLine() throws IOException { 
            while (reader.readLine() != null) 
                return reader.readLine();      
            return null;
    }
    
    private Lancamento processaLinha(String linha) throws ParseException{
        Integer conta;
        String descricao;
        Double valor;
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formato.parse(linha.substring(12,14)+"/"+linha.substring(10,12)+"/"+linha.substring(6,10));
        
        conta = Integer.parseInt(linha.substring(0,6)); 
        descricao = linha.substring(14,74);     
        valor = Double.parseDouble(linha.substring(75));        
        
        return new Lancamento(conta, data, descricao, valor);
        
    }
    
    private Lancamento getNextLancamento() throws IOException, ParseException {
        while(getNextLine()!=null)
            return processaLinha(getNextLine());
        return null;
    }
    
    public List<Lancamento> getLancamentos() throws IOException, ParseException {
        List<Lancamento> lancamento = new ArrayList<>();
        
        while(getNextLancamento() != null)
            lancamento.add(getNextLancamento());
        
        sort(lancamento, new LancamentoComparator());
        
        return lancamento;
    }
    
}
