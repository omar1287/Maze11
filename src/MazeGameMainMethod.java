
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author lenovo
 */
public class MazeGameMainMethod extends JFrame implements KeyListener {

    GLCanvas gl;
    MidLevel listner = new MidLevel();

    public static void main(String[] args) {
        final MazeGameMainMethod app = new MazeGameMainMethod();
//        JOptionPane.showMessageDialog(null, "Under leadership of \nProfessor: Mohammed El-Gayar \n& Professor:Hend Dawood");
//        JOptionPane.showMessageDialog(null, "How to play ;)  \n use arrow up , down , left and right\n to move and reach to final destination\n any errors call me \n G.M. MYehia:01113649361 \n& his parteners...");
////        JOptionPane.showMessageDialog(null, "Choose Level");
//        JOptionPane.showMessageDialog(null, "Let's play");




// show what we've done
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {

                        app.setVisible(true);



                    }


                }
        );
    }

    public MazeGameMainMethod() {
//set the JFrame title
        super("Maze");

//kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//only three JOGL lines of code ... and here they are
        GLCapabilities glcaps2 = new GLCapabilities();
        gl = new GLCanvas(glcaps2);//GLDrawableFactory.getFactory().creategl(glcaps);
        gl.addGLEventListener(
                listner
        );
        gl.addKeyListener(this);
//add the gl just like we would any Component
        getContentPane().add(gl, BorderLayout.CENTER);
        setSize(1230, 700);
//center the JFrame on the screen
        centerWindow(this);
    }

    public void centerWindow(Component frame) {
        Dimension screenSize
                = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        frame.setLocation(
                (screenSize.width - frameSize.width) >> 1,
                (screenSize.height - frameSize.height) >> 1
        );
    }


    @Override
    public void keyTyped(KeyEvent ke) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
//            listner.px += 10;
//            gl.repaint();
//
//        }
    }
    @Override
    public void keyPressed(KeyEvent ke) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            switch (ke.getKeyCode()) {
                case KeyEvent.VK_DOWN:
                    listner.buffer_py -= 5;
                    //listner.py -= 10;
                    gl.repaint();
                    break;
                case KeyEvent.VK_UP:
                    listner.buffer_py += 5;
                    //listner.py += 10;
                    gl.repaint();
                    break;
                case KeyEvent.VK_RIGHT:
                    listner.buffer_px += 5;
                    //listner.px += 10;
                    gl.repaint();
                    break;
                case KeyEvent.VK_LEFT:
                    listner.buffer_px -= 5;
                    //listner.px -= 10;
                    gl.repaint();
                    break;

            }
        }// end switch    
        catch (Exception ee) {
            JOptionPane.showMessageDialog(null, "Error: " + ee.getMessage());
        }
    }

    public void keyReleased(KeyEvent ke) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}