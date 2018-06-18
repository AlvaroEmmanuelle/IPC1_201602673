package utilidades;

import java.util.concurrent.ThreadLocalRandom;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TirarDado extends Thread{
    private Integer randomDado = ThreadLocalRandom.current().nextInt(1, 5 + 1);
    private Integer randomDireccion = ThreadLocalRandom.current().nextInt(1, 3 + 1);
    private JLabel lbldado;
    private ImageIcon iconoDado;
    int i=1;
    boolean seguir = true;
    
    public TirarDado(JLabel lbldado) {
        this.lbldado = lbldado;
    }
    
    public void run(){
        try {
            while(seguir){
                if(i==1){iconoDado = new ImageIcon("src/imagen/dado_1.PNG"); lbldado.setToolTipText("1");}
                if(i==2){iconoDado = new ImageIcon("src/imagen/dado_2.PNG"); lbldado.setToolTipText("2");}
                if(i==3){iconoDado = new ImageIcon("src/imagen/dado_3.PNG"); lbldado.setToolTipText("3");}
                if(i==4){iconoDado = new ImageIcon("src/imagen/dado_4.PNG"); lbldado.setToolTipText("4");}
                if(i==5){iconoDado = new ImageIcon("src/imagen/dado_5.PNG"); lbldado.setToolTipText("5");}
                if(i==6){iconoDado = new ImageIcon("src/imagen/dado_6.PNG"); lbldado.setToolTipText("6");}
                lbldado.setIcon(iconoDado);
                i++;
                Thread.sleep(300);
                if(i>randomDado){ seguir = false; }
            }
            this.interrupt();
        }
        catch(Exception e){}
    }

    public JLabel getLbldado() {
        return lbldado;
    }

    public void setLbldado(JLabel lbldado) {
        this.lbldado = lbldado;
    }
    
}