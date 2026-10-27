import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadioButtonDemo extends JFrame implements ActionListener {
    private final JLabel picture = new JLabel();

    public RadioButtonDemo() {
        super("RadioButtonDemo");

        String[] pets = {"Bird", "Cat", "Dog", "Rabbit", "Pig"};
        ButtonGroup group = new ButtonGroup();        
        JPanel radioPanel = new JPanel(new GridLayout(0, 1));

        for (String pet : pets) {
            JRadioButton rb = new JRadioButton(pet);
            rb.setActionCommand(pet);                   
            rb.addActionListener(this);
            group.add(rb);
            radioPanel.add(rb);
            if (pet.equals("Pig")) rb.setSelected(true); 
        }

        showPicture("Pig");

        setLayout(new BorderLayout(10, 10));
        add(radioPanel, BorderLayout.WEST);
        add(picture, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void showPicture(String pet) {
        ImageIcon icon = new ImageIcon("images/" + pet + ".gif");
        if (icon.getIconWidth() == -1) {               
            picture.setIcon(null);
            picture.setText(pet);
        } else {
            picture.setText(null);
            picture.setIcon(icon);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pet = e.getActionCommand();
        showPicture(pet);
        JOptionPane.showMessageDialog(this, "You selected: " + pet,
                "Your Choice", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RadioButtonDemo::new);
    }
}