import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

interface TreeViewer {
    public void displayTree();
}

class AppleTree implements TreeViewer {
    int height;
    String place;
    JFrame frame;
    JLabel treeLabel;
    ImageIcon treeImage;
    JButton growButton, heightButton;
    JPanel panel;

    public AppleTree(int h, String p) {
        height = h;
        place = p;

        frame = new JFrame("Apple Tree Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        // Load the image of the tree
        treeImage = new ImageIcon("tree.jpg");

        treeLabel = new JLabel(treeImage);
        growButton = new JButton("Grow");
        heightButton = new JButton("Get Height");

        growButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                grow();
                displayTree();
            }
        });

        heightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "The current height of the tree is " + returnHeight() + " feet.");
            }
        });
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(treeLabel);
        panel.add(growButton);
        panel.add(heightButton);
        frame.add(panel);
    }

    public void displayTree() {
        treeLabel.setIcon(new ImageIcon(treeImage.getImage().getScaledInstance(height * 10, height * 10, Image.SCALE_SMOOTH)));
        frame.setVisible(true);
    }

    public void grow() {
        height += 2;
    }

    public int returnHeight() {
        return height;
    }
}