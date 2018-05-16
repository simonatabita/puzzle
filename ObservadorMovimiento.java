/*
 * Javier Abellán, 30 de Abril de 2003
 *
 * Interface para los observadores de movimientos del modelo de puzzle.
 */ 

/**
 * Aquellas clases interesadas en los movimientos del puzzle (la interface
 * gráfica, el algoritmo de ordenación, etc), pueden añadir un observador
 * que cumpla esta interface.
 */
public interface ObservadorMovimiento {
    
    /**
     * Cada vez que en el puzzle se mueva una pieza, se avisará a los
     * observadores llamando a este método, pasando la antigua posición de la
     * pieza dentro del puzzle y su nueva posición.
     */
    public void tomaMovimiento (int filaVieja, int columnaVieja,
        int filaNueva, int columnaNueva);
    
    /**
     * Cuando un movimiento haga que el puzzle esté totalmente ordenado, se
     * avisará a los observadores llamando a este método.
     */
    public void ordenado();
}