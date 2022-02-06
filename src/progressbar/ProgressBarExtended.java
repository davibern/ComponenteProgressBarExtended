package progressbar;

import java.awt.Color;
import java.io.Serializable;
import javax.swing.JProgressBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author davibern
 * @version 1.0
 */
public class ProgressBarExtended extends JProgressBar implements Serializable  {
    
    private Rangos rangos;
    private Color color1;
    private Color color2;
    private Color color3;
    private RangoAlcanzadoListener listener;

    public ProgressBarExtended() {
        // Se definen los intervalos
        rangos = new Rangos(35, 75);
        
        // Se añade el listener y se redefine el método stateChanged
        this.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                comprobarZona();
            }
        });
    }

    public Rangos getRangos() {
        return rangos;
    }

    public void setRangos(Rangos rangos) {
        this.rangos = rangos;
    }

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    public Color getColor3() {
        return color3;
    }

    public void setColor3(Color color3) {
        this.color3 = color3;
    }

    public RangoAlcanzadoListener getListener() {
        return listener;
    }

    public void setListener(RangoAlcanzadoListener listener) {
        this.listener = listener;
    }
    
    public void comprobarZona() {
        if (rangos != null) {
            if (this.getValue() < rangos.getRango1()) {
                this.setForeground(color1);
                if (this.getValue() == rangos.getRango1() - 1) {
                    if (listener != null) {
                        listener.capturarZona1Alcanzada(new RangoAlcanzado(this));
                    }
                }
            } else if (this.getValue() >= rangos.getRango1() && this.getValue() <= rangos.getRango2()) {
                this.setForeground(color2);
                if (this.getValue() == rangos.getRango1() || this.getValue() == rangos.getRango2()) {
                    if (listener != null) {
                        listener.capturarZona2Alcanzada(new RangoAlcanzado(this));
                    }
                }
            } else {
                this.setForeground(color3);
                if (this.getValue() == rangos.getRango2() + 1) {
                    if (listener != null) {
                        listener.capturarZona3Alcanzada(new RangoAlcanzado(this));
                    }
                }
            }    
        }
    }
    
}
