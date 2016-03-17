import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;
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
    public void bounce(int numBolas)
    {
        int ground = 400;// position of the ground line
        myCanvas.setVisible(true);
        ArrayList<Color> colores = new ArrayList<>();
        ArrayList<BouncingBall> bolas = new ArrayList<>();
        colores.add(Color.RED);
        colores.add(Color.BLUE);
        colores.add(Color.GREEN);
        colores.add(Color.YELLOW);
        for (int i = 0; i<numBolas;i++)
        {
            Random aleatorio = new Random();
            int posicionX = aleatorio.nextInt(250);
            int posicionY = aleatorio.nextInt(250);
            int radio = aleatorio.nextInt(75);
            BouncingBall ball = new BouncingBall(posicionX,posicionY,radio,colores.get(aleatorio.nextInt(colores.size())),ground, myCanvas);
            ball.draw();
            bolas.add(ball);

        }
        myCanvas.drawLine(50, ground, 550, ground);

        boolean finished =  false;
        while (!finished) 
        {
            myCanvas.wait(25);// small delay
            for(BouncingBall ball: bolas)
            {
                ball.move();
                if(ball.getXPosition() >= 550) 
                {
                 finished = true;
                }
            }

                // stop once ball has travelled a certain distance on x axis
        }
        
    }
}
