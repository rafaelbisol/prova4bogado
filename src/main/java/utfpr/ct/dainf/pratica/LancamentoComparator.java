package utfpr.ct.dainf.pratica;

import java.util.Comparator;

/**
 * Linguagem Java
 * @author Bisol
 */
public class LancamentoComparator implements Comparator<Lancamento> {

    public LancamentoComparator() {
    }
    
    @Override
    public int compare(Lancamento t, Lancamento t1) {
       if(t.getConta()>t1.getConta())
           return 1;
       else if(t.getConta()<t1.getConta())
           return -1;
       else
           if(t.getData().before(t1.getData()))
              return 1;
            else
               return -1;       
    }
    
}
