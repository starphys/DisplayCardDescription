package edu.sjsu.assignmentgroup;

import javax.swing.*;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Playing Card Reader");
        JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);

        JButton button = new JButton("Submit");
        JTextField input = new JTextField(3);
        JLabel prompt = new JLabel("Enter a card:");
        JLabel instructions = new JLabel("""
        <html>Enter a card by rank and suit to get its description.<br>
        Accepted formats are RS or RRS, as in AH for Ace of Hearts or 10C for Ten of Clubs. </html>""");
        JTextField description = new JTextField(3);
        description.setEditable(false);


        panel.add(instructions, BorderLayout.NORTH);
        panel.add(prompt, BorderLayout.WEST);
        panel.add(input, BorderLayout.CENTER);
        panel.add(button, BorderLayout.EAST);
        panel.add(description, BorderLayout.SOUTH);

        button.addActionListener(e->{
            String name = input.getText();
            if(name.isEmpty()) {
                description.setText("Please enter a card by rank and suit (RS or RRS).");
            }
            else {
                Card card = new Card(name);
                description.setText(card.getDescription());
            }
        });

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
