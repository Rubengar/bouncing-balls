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
            int radio = aleatorio.nextInt(40);
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

    /**
     * Metodo que crea un rectangulo y dentro de el un numero de bolas que indique el usuario
     */
    public void boxBounce(int numBolas)
    {
        myCanvas.drawLine(0, 0, 200,0);
        myCanvas.drawLine(200, 0, 200, 300);
        myCanvas.drawLine(200, 300, 0, 300);
        myCanvas.drawLine(0, 300, 0, 0);
        
        myCanvas.setVisible(true);
        ArrayList<Color> colores = new ArrayList<>();
        ArrayList<BoxBall> bolas = new ArrayList<>();
        colores.add(Color.RED);
        colores.add(Color.BLUE);
        colores.add(Color.GREEN);
        colores.add(Color.YELLOW);
        for (int i = 0; i<numBolas;i++)
        {
            Random aleatorio = new Random();
            int posicionX = aleatorio.nextInt(200);
            int posicionY = aleatorio.nextInt(300);
            int radio = aleatorio.nextInt(20);
            BoxBall ball = new BoxBall(posicionX,posicionY,radio,colores.get(aleatorio.nextInt(colores.size())), myCanvas);
            ball.draw();
            bolas.add(ball);

        }

        boolean finished =  false;
        while (!finished) 
        {
            myCanvas.wait(25);// small delay
            for(BoxBall ball: bolas)
            {
                ball.move();
                if(ball.getXPosition() >= 250) 
                {
                    ball.move();
                }
                if(ball.getYPosition() >= 150) 
                {
                    ball.move();
                }
            }
            // stop once ball has travelled a certain distance on x axis
        }
    }
}
