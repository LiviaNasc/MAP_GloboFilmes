package exceptions;
@SuppressWarnings("serial")
public class ExceptionFilmeNaoExiste extends Exception{
    public ExceptionFilmeNaoExiste(String nome) {
        super("Filme: "+nome +" não existe", new Throwable("filme incorreto ou não existe"));
    }
}
