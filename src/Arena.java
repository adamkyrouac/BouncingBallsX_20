import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class Arena extends JPanel{
    private Color bkg;
    public static int xSize;
    public static int ySize;
    private Ball[] balls = new Ball[20];

    public Arena(Color inBKG, int inX, int inY){
        //System.out.println("Arena created");
        bkg = inBKG;
        //System.out.println("Background set");
        xSize = inX;
        //System.out.println("X size set to " + xSize);
        ySize = inY;
        //System.out.println("Y size set to " + ySize);
        setPreferredSize(new Dimension(xSize, ySize));
        //System.out.println("Dimension set");
        setBackground(bkg);
        //System.out.println("Background set");
        balls();
        //System.out.println("Balls method called");

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent z) {
                xSize = getWidth();
                ySize = getHeight();
            }
        });
    }

    //Ball ball = new Ball(50, 0, 0, 16, 8, Color.BLUE);
    public void balls() {
        for (int i = 0; i < balls.length; i++) {
            //System.out.println(i + " time through loop: ");
            int rXS;
            int rYS;
            int rSize = (int)(Math.random() * 61 + 10);
            int rX = (int)(Math.random() * (xSize - rSize));
            int rY = (int)(Math.random() * (ySize - rSize));
            do {rXS = (int)(Math.random() * 37 - 16);} while(!(Math.abs(rXS) >= 1));
            do {rYS = (int)(Math.random() * 37 - 16);} while(!(Math.abs(rYS) >= 1));
            Color rColor = new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
            //System.out.println("Size: " + rSize + " X: " + rX + " Y: " + rY + " XS: " + rXS + " YS: " + rYS + " Color: " + rColor);

            balls[i] = new Ball(rSize, rX, rY, rXS, rYS, rColor);
        }
    }
//    public int getCount(){
//        return balls.length;
//    }

    @Override
    public void paintComponent(Graphics g){
        // calls the (not overridden) paintComponent() of JPanel and passes it a Graphics object.
        // Bring back the right details for regular old paintComponent()
        super.paintComponent(g);
//        ball.draw(g);
//        repaint(); // makes sure that even if the ball doesn't move, the background stays green
//        ball.move(g);
        for(int i = 0; i < balls.length; i++) {
            balls[i].draw(g);
            balls[i].move(g);
        }

        try{
            // change back to 16 later
            Thread.sleep(16);
        } catch(Exception e) {System.out.println(e);}
        repaint();
    }
}
