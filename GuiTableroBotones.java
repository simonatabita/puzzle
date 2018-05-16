/*
 * Javier Abellán. 27 de Abril de 2003
 * 
 * Juego del puzzle. Clase JuegoPuzzle. Clase visual que contiene el tablero
 * y los botones de ordenar y desordenar puzzle.
 */
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

/**
 * Interface gráfica del juego del puzzle. Contiene el tablero en pantalla y
 * los botones de ordenar y desordenar puzzle.
 * Utiliza Puzzle, que es la clase donde está almacenado el tablero y Ordenador,
 * que es la clase que sabe ordenar y desordenar el puzzle.
 */
public class GuiTableroBotones extends JPanel{
    /**
     * Constructor. Recibe
     * - Una instancia de Ordenador, para ordenar y desordenar el puzzle cuando
     * se pulsen los botones de "Ordenar" y "Desordenar".
     * - Un array de nombres de ficheros .gif. El primero es la imagen del hueco
     * y los demás las piezas del puzzle. Se supone que son imágenes de 32x32.
     * - Una instancia de Puzzle, que es donde está el juego.
     *
     * Instancia un GuiTablero y los botones de "Ordenar" y "Desordenar", 
     * poniendoles los ActionListener correspondientes.
     */
    public GuiTableroBotones(Ordenador nuevoOrdenador, Image[] imagenes, 
        Puzzle unPuzzle) 
    {
        /* Almacena los parámetros recibidos */
        this.unOrdenador = nuevoOrdenador;
        this.unPuzzle = unPuzzle;
        
        /* Crea un tablero visual y lo dibuja junto con los botones de 
         * "Ordenar" y "Desordenar" */
        tablero = new GuiTablero (imagenes, unPuzzle);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add (tablero);
        this.add (botonOrdenar);
        this.add (botonDesordenar);
        
        /* Añade un ActionListener al botón de "Desordenar", que llama al metodo
         * desordena() de Ordenador */
        botonDesordenar.addActionListener(new ActionListener () {
            public void actionPerformed (ActionEvent e)
            {
                if (unOrdenador != null)
                    unOrdenador.desordena();
            }
        });
        
        /* Añade un ActionListener al botón de "Ordenar", que llama al metodo
         * ordena() de Ordenador */
        botonOrdenar.addActionListener(new ActionListener () {
            public void actionPerformed (ActionEvent e)
            {
                if (unOrdenador != null)
                    unOrdenador.ordena();
            }
        });
      
    }
                
    /** Tablero visual donde se representan las piezas */
    GuiTablero tablero;
    
    /** Botón de "Ordenar" puzzle */
    JButton botonOrdenar = new JButton("Ordenar");
    
    /** Botón de "Desordenar" puzzle */
    JButton botonDesordenar = new JButton ("Desordenar");
    
    /** Para ordenar y desordenar el puzzle */
    Ordenador unOrdenador;
    
    /** El juego del puzzle */
    Puzzle unPuzzle;
    
}