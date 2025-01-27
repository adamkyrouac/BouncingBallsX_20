import javax.swing.*;
import java.awt.*;


public class Ball {

    //FIELDS
    private int size;
    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;
    private int radius;
    private Color fill;


    //CONSTRUCTOR
    public Ball(int inSize, int inX, int inY, int inXSpeed, int inYSpeed, Color inFill){
        size = inSize;
        x = inX;
        y = inY;
        xSpeed = inXSpeed;
        ySpeed = inYSpeed;
        fill = inFill;
        radius = size / 2;
    }


    //SETTER METHODS
    public void setSize(int size) {
        this.size = size;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setFill(Color fill) {
        this.fill = fill;
    }


    //GETTER METHODS
    public int getSize() {
        return size;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public Color getFill() {
        return fill;
    }


    public void draw(Graphics g){
        g.setColor(fill);
        g.fillOval(x, y, size, size);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, size, size);
    }

    public void back() {
        if(x > Arena.xSize - size + 1) {
            x = Arena.xSize - size - 1;
        }
        if(y > Arena.ySize - size + 1) {
            y = Arena.ySize - size - 1;
        }
        if (x < 0 - 1) {
            x = 1;
        }
        if(y < 0 - 1) {
            y = 1;
        }
    }

    public void bounce() {
        if (x > Arena.xSize - size || x < 0) {
            xSpeed = -1 * xSpeed;
        }
        if (y > Arena.ySize - size || y < 0) {
            ySpeed = -1 * ySpeed;
        }
        back();
    }

    public void move(Graphics g){
        x += xSpeed;
        y += ySpeed;
        bounce();
    }

}
