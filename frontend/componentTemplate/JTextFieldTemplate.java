package assignments.assignment4.frontend.componentTemplate;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Class ini merupakan subclass dari JTextfield.
 * Class ini dibuat untuk mengurangi pengulangan pembuatan default template pada setiap instansiasi JTextfield.
 * Class ini mempermudah kita untuk mengatur style textfield hanya dari constructor.
 */
public class JTextFieldTemplate extends JTextField {
    public JTextFieldTemplate(){
        this.setBorder(new LineBorder(new Color(56, 128, 160),1));
        this.setPreferredSize(new Dimension(400, 30));
    }

    public JTextFieldTemplate(int width, int height){
        this();
        this.setPreferredSize(new Dimension(width, height));
    }
}
