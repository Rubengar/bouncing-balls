import java.awt.Color;
import java.util.*;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numbolas)
    {
        int ground = 400;   // position of the ground line
        Random aleatorio = new Random();
        myCanvas.setVisible(true);
        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        ArrayList<BouncingBall> bolas = new ArrayList<>();
        for (int cont = 0;cont<numbolas;cont++)
        {
            int diametro = aleatorio.nextInt(25)+aleatorio.nextInt(25);
            Color colorA = new Color(aleatorio.nextInt(255),aleatorio.nextInt(255),aleatorio.nextInt(255));
            bolas.add(new BouncingBall(aleatorio.nextInt(150), aleatorio.nextInt(150), diametro, colorA, ground, myCanvas));
            bolas.get(cont).draw();
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            int contbol = 0;
            myCanvas.wait(50);           // small delay
            for (int cont = 0;cont<numbolas;cont++)
            {
                bolas.get(cont).move();
            }
            // stop once ball has travelled a certain distance on x axis
            while(contbol < bolas.size())
            {
                if(bolas.get(contbol).getXPosition() >= 550) {
                    finished = true;
                }
                contbol++;
            }
        }
    }
    
    /**
     * Metodo que genera bolas dentro de un rectangulo.
     */
    public void boxBounce(int numbolas)
    {
        Random aleatorio = new Random();
        myCanvas.setVisible(true);
        myCanvas.drawLine(50, 50, 550, 50);
        myCanvas.drawLine(550, 50, 550, 400);
        myCanvas.drawLine(550, 400, 50, 400);
        myCanvas.drawLine(50, 400, 50, 50);
        
        ArrayList<BoxBall> bolas = new ArrayList<>();
        for (int cont = 0;cont<numbolas;cont++)
        {
            int diametro = aleatorio.nextInt(25)+aleatorio.nextInt(25);
            Color colorA = new Color(aleatorio.nextInt(255),aleatorio.nextInt(255),aleatorio.nextInt(255));
          
            int ladx = aleatorio.nextInt(2);
            int lady = aleatorio.nextInt(2);
            if (ladx == 0)
            {
                ladx = -1;
            }
            if (lady == 0)
            {
                lady = -1;
            }
          
            int posInix = aleatorio.nextInt(500);
            int posIniy = aleatorio.nextInt(350);
            if(posInix < 50)
            {
                posInix = 100;
            }
            if(posIniy < 50)
            {
                posIniy = 100;
            }
          
            bolas.add(new BoxBall(posInix, posIniy, diametro, colorA, 400, 50, 50, 550, ladx, lady, myCanvas));
            bolas.get(cont).draw();
        }
        
        while(true)
        {
            myCanvas.wait(50);           // small delay
            for (int cont = 0;cont<numbolas;cont++)
            {
                bolas.get(cont).move();
            }
        }
    }
}
