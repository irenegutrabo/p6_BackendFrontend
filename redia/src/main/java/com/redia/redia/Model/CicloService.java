public class CicloService {
    

    public void eliminarCiclo (Long id){
        RepositoryCiclo.deleteById(id);
    }
}
