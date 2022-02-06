package progressbar;


import java.io.Serializable;

/**
 *
 * @author davibern
 * @version 1.0
 */
public class Rangos implements Serializable {
    
    private double rango1;
    private double rango2;

    public Rangos(int rango1, int rango2) {
        this.rango1 = rango1;
        this.rango2 = rango2;
    }

    public double getRango1() {
        return rango1;
    }

    public void setRango1(double rango1) {
        this.rango1 = rango1;
    }

    public double getRango2() {
        return rango2;
    }

    public void setRango2(double rango2) {
        this.rango2 = rango2;
    }
    
}
