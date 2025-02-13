import java.awt.*;

public class Ball {

    //FIELDS
    private double size;
    private double x;
    private double y;
    private double xCenter;
    private double yCenter;
    private double xSpeed;
    private double ySpeed;
    int xDir;
    int yDir;
    private double speed;
    private double radius;
    private Color fill;
//    private double[] distance = new double[Arena.getCount() - 1];


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
        radius = size / 2.0;
        xCenter = x + radius;
        yCenter = y + radius;
    }

    //SETTER METHODS
    public void setSize(int size) {
        this.size = size;
        //radius = size / 2;
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
        speed = Math.sqrt(Math.pow(xSpeed, 2) + Math.pow(ySpeed, 2));

    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
        if(ySpeed > 0) {yDir = 1;}
        if(ySpeed < 0) {yDir = -1;}
        speed = Math.sqrt(Math.pow(xSpeed, 2) + Math.pow(ySpeed, 2));

    }

    public void setFill(Color fill) {
        this.fill = fill;
    }


    //GETTER METHODS
    public double getRadius() {
        return radius;
    }

    public double getSize() {
        return size;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getXCenter(){
        return xCenter;
    }

    public double getYCenter(){
        return yCenter;
    }

    public double getxSpeed() {
        return xSpeed;
    }

    public double getySpeed() {
        return ySpeed;
    }

    public Color getFill() {
        return fill;
    }


    public void draw(Graphics g){
        g.setColor(fill);
        g.fillOval((int)x, (int)y, (int)size, (int)size);
        g.setColor(Color.BLACK);
        g.drawOval((int)x, (int)y, (int)size, (int)size);
        //for(int i = 0; i < distance.length; i++) {
        //    distance[i] = Math.abs(Math.pow(/*other xCenter*/ - xCenter, 2) + Math.pow(/*other yCenter*/ - yCenter, 2));
        //}

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
        if (x < -1) {
            x = 1;
            xCenter = x + radius;
        }
        if(y < -1) {
            y = 1;
            yCenter = x + radius;
        }
    }

    public void bounce() {
        if (x > Arena.xSize - size || x < 0) {
            //xSpeed = -1 * xSpeed;
            // Sets the x speed to a random number (0, total speed) that is int he opposite direction, then rounds down
            xSpeed = -1 * xDir * (Math.random() * speed);
            // Sets the y speed to
            ySpeed = yDir * Math.sqrt(Math.pow(speed, 2) - Math.pow(xSpeed, 2));
            if(xSpeed > 0) {xDir = 1;}
            if(xSpeed < 0) {xDir = -1;}
            if(ySpeed > 0) {yDir = 1;}
            if(ySpeed < 0) {yDir = -1;}
            speed = Math.sqrt(Math.pow(xSpeed, 2) + Math.pow(ySpeed, 2));
            //System.out.println(xSpeed + "\t" + ySpeed + "\t" + speed);
        }
        if (y > Arena.ySize - size || y < 0) {
            //ySpeed = -1 * ySpeed;
            ySpeed = -1 * yDir * (Math.random() * speed);
            xSpeed = xDir * Math.sqrt(Math.pow(speed, 2) - Math.pow(ySpeed, 2));
            if(xSpeed > 0) {xDir = 1;}
            if(xSpeed < 0) {xDir = -1;}
            if(ySpeed > 0) {yDir = 1;}
            if(ySpeed < 0) {yDir = -1;}
            speed = Math.sqrt(Math.pow(xSpeed, 2) + Math.pow(ySpeed, 2));
            //System.out.println(xSpeed + "\t" + ySpeed + "\t" + speed);
        }
        back();
    }

//    public void ballBounce(){
//        for(int i = 0; i < distance.length; i++) {
//            if(distance[i] < radius + /*other radius*/);
//            System.out.println("Balls " + );
//        }
//    }

    public void move(Graphics g){
        x += xSpeed;
        if(xSpeed > 0) {xDir = 1;}
        if(xSpeed < 0) {xDir = -1;}
        xCenter = x + radius;
        y += ySpeed;
        if(ySpeed > 0) {yDir = 1;}
        if(ySpeed < 0) {yDir = -1;}
        yCenter = y + radius;
        bounce();
    }

    // make the balls bounce off each other
    // make the balls bounce off the walls at random angles.
}
