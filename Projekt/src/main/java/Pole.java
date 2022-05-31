import javax.swing.JComponent;
import javax.swing.JFrame;

public class Pole extends JComponent{
    protected Integer x;
    protected Integer y;

    protected Integer width = 100;
    protected Integer height = 100;
    protected static JFrame parent;


    public Pole(JFrame f, int i, int j) {
        parent = f;
        x = 8 + 100 * i;
        y = 15 + 100 * j;
        setBounds(x, y, width, height);
        setLayout(null);
        setDoubleBuffered(false);
        setVisible(true);
    }
}
