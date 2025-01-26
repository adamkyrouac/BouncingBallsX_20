import javax.swing.*;
import java.awt.*;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Arena panel = new Arena(Color.GREEN, 500,500);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}