package javetours.controller;

/**
 * Clase Singleton de Banco.
 *
 * @author Juana Valentina Mendoza Santamaría
 * @author Camilo Ordoñez García 
 * @author Abrahan Ignacio Ayala Acuña
 * @author Pablo Santander Alvarez 
 */
public class AgenciaSingleton {
    private final Agencia agencia;
    private static AgenciaSingleton agenciaSingleton;

    private AgenciaSingleton(Agencia agencia) {
        this.agencia = agencia;
    }
    
    public static AgenciaSingleton getSingletonInstance(Agencia agencia) {
        if (agenciaSingleton == null) {
            agenciaSingleton = new AgenciaSingleton(agencia);
        }
        return agenciaSingleton;
    }

    public Agencia getAgencia() {
        return this.agencia;
    }
}
