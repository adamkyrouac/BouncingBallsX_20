import java.awt.*;


public class Ball {

    //FIELDS
    private int size;
    private int x;
    private int y;
    private int xCenter;
    private int yCenter;
    private int xSpeed;
    private int ySpeed;
    int xDir;
    int yDir;
    private double speed;
    private int radius;
    private Color fill;


    //CONSTRUCTOR
    public Ball(int inSize, int inX, int inY, int inXSpeed, int inYSpeed, Color inFill){
        size = inSize;
        x = inX;
        y = inY;
        xSpeed = inXSpeed;
        ySpeed = inYSpeed;
        if(xSpeed > 0) {xDir = 1;}
        if(xSpeed < 0) {xDir = -1;}
        if(ySpeed > 0) {yDir = 1;}
        if(ySpeed < 0) {yDir = -1;}
        speed = Math.sqrt(Math.pow(xSpeed, 2) + Math.pow(ySpeed, 2));
        fill = inFill;
        radius = size / 2;
        xCenter = x + radius;
        yCenter = y + radius;
    }

    //SETTER METHODS
    public void setSize(int size) {
        this.size = size;
        radius = size / 2;
    }

    public void setX(int x) {
        this.x = x;
        xCenter = x + radius;
    }

    public void setY(int y) {
        this.y = y;
        yCenter = y + radius;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
        if(xSpeed > 0) {xDir = 1;}
        if(xSpeed < 0) {xDir = -1;}
        if(ySpeed > 0) {yDir = 1;}
        if(ySpeed < 0) {yDir = -1;}
        speed = Math.sqrt(Math.pow(xSpeed, 2) + Math.pow(ySpeed, 2));

    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
        if(xSpeed > 0) {xDir = 1;}
        if(xSpeed < 0) {xDir = -1;}
        if(ySpeed > 0) {yDir = 1;}
        if(ySpeed < 0) {yDir = -1;}
        speed = Math.sqrt(Math.pow(xSpeed, 2) + Math.pow(ySpeed, 2));

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

    public int getXCenter(){
        return xCenter;
    }

    public int getYCenter(){
        return yCenter;
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
            xCenter = x + radius;
        }
        if(y > Arena.ySize - size + 1) {
            y = Arena.ySize - size - 1;
            yCenter = y + radius;
        }
        if (x < 0 - 1) {
            x = 1;
            xCenter = x + radius;
        }
        if(y < 0 - 1) {
            y = 1;
            yCenter = x + radius;
        }
    }

    public void bounce() {
        if (x > Arena.xSize - size || x < 0) {
            //xSpeed = -1 * xSpeed;
            xSpeed = -1 * xDir * (int)(Math.random() * speed);
            ySpeed = (int)Math.sqrt(Math.pow(speed, 2) - Math.pow(xSpeed, 2));
            System.out.println("X Speed: " + xSpeed + " Y Speed: " + ySpeed);
            if(xSpeed > 0) {xDir = 1;}
            if(xSpeed < 0) {xDir = -1;}
            if(ySpeed > 0) {yDir = 1;}
            if(ySpeed < 0) {yDir = -1;}
        }
        if (y > Arena.ySize - size || y < 0) {
            //ySpeed = -1 * ySpeed;
            ySpeed = -1 * yDir * (int)(Math.random() * speed);
            xSpeed = (int)Math.sqrt(Math.pow(speed, 2) - Math.pow(ySpeed, 2));
            System.out.println("X Speed: " + xSpeed + " Y Speed: " + ySpeed);
            if(xSpeed > 0) {xDir = 1;}
            if(xSpeed < 0) {xDir = -1;}
            if(ySpeed > 0) {yDir = 1;}
            if(ySpeed < 0) {yDir = -1;}
        }
        back();
    }

    public void move(Graphics g){
        x += xSpeed;
        if(xSpeed > 0) {xDir = 1;}
        if(xSpeed < 0) {xDir = -1;}
        if(ySpeed > 0) {yDir = 1;}
        if(ySpeed < 0) {yDir = -1;}
        xCenter = x + radius;
        y += ySpeed;
        if(xSpeed > 0) {xDir = 1;}
        if(xSpeed < 0) {xDir = -1;}
        if(ySpeed > 0) {yDir = 1;}
        if(ySpeed < 0) {yDir = -1;}
        yCenter = y + radius;
        bounce();
    }

    // make the balls bounce off each other
    // make the balls bounce off the walls at random angles.
}
