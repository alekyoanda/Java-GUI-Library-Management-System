package assignments.assignment4.frontend.componentTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Class ini merupakan subclass dari JButton.
 * Class ini dibuat untuk  mengurangi pengulangan pembuatan default template pada setiap instansiasi JButton.
 * Class ini mempermudah kita untuk mengatur style button hanya dari constructor.
 */
public class JButtonTemplate extends JButton {
    public JButtonTemplate(String btnMsg) {
        super(btnMsg);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setBackground(new Color(56, 128, 135));
        this.setForeground(new Color(246, 246, 242));
        addMouseListener(new hoverButton());
        addMouseListener(new exitButton());
    }

    public JButtonTemplate(String btnMsg, int width, int height) {
        this(btnMsg);
        this.setPreferredSize(new Dimension(width, height));
    }

    private class hoverButton extends MouseAdapter {
        @Override
        public void mouseEntered(MouseEvent e) {
            setBackground(new Color(80, 152, 163));
        }
    }

    private class exitButton extends MouseAdapter {
        @Override
        public void mouseExited(MouseEvent e) {
            setBackground(new Color(56, 128, 135));
        }
    }
}
