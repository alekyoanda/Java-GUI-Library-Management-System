package assignments.assignment4.frontend.componentTemplate;

import javax.swing.*;
import java.awt.*;

/**
 * Class ini merupakan subclass dari JLabel.
 * Class ini dibuat untuk mengurangi pengulangan pembuatan default template pada setiap instansiasi JLabel.
 * Class ini mempermudah kita untuk mengatur style label hanya dari constructor.
 */
public class JLabelTemplate extends JLabel {
    public JLabelTemplate(String labelMsg){
        super(labelMsg, null, JTextField.CENTER);
        this.setForeground(new Color(56, 128, 135));
        this.setFont(new Font("Verdana", Font.PLAIN, 12));
    }

    public JLabelTemplate(String labelMsg, int fontSize){
        this(labelMsg);
        this.setFont(new Font("Verdana", Font.PLAIN, fontSize));
    }

    public JLabelTemplate(String labelMsg, int horizontalAllignment, int fontSize){
        this(labelMsg);
        this.setHorizontalAlignment(horizontalAllignment);
        this.setFont(new Font("Verdana", Font.PLAIN, fontSize));
    }
}
