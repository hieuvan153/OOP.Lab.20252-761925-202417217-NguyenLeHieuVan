package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add DVD to store");
    }

    @Override
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(6, 2, 5, 5));
        center.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        center.add(new JLabel("Title: "));
        JTextField tfTitle = new JTextField();
        center.add(tfTitle);

        center.add(new JLabel("Category: "));
        JTextField tfCategory = new JTextField();
        center.add(tfCategory);

        center.add(new JLabel("Director: "));
        JTextField tfDirector = new JTextField();
        center.add(tfDirector);

        center.add(new JLabel("Length: "));
        JTextField tfLength = new JTextField();
        center.add(tfLength);

        center.add(new JLabel("Cost: "));
        JTextField tfCost = new JTextField();
        center.add(tfCost);

        center.add(new JLabel());
        JButton btnAdd = new JButton("Add DVD: ");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String title = tfTitle.getText().trim();
                    String category = tfCategory.getText().trim();
                    String director = tfDirector.getText().trim();
                    String lengthStr = tfLength.getText().trim();
                    String costStr = tfCost.getText().trim();

                    if (title.isEmpty()) {
                        JOptionPane.showMessageDialog(AddDigitalVideoDiscToStoreScreen.this, "Enter the title of the DVD: ", "Error", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    double cost = costStr.isEmpty() ? 0.0 : Double.parseDouble(costStr);

                    DigitalVideoDisc dvd;
                    if (!lengthStr.isEmpty() && !director.isEmpty()) {
                        int length = Integer.parseInt(lengthStr);
                        dvd = new DigitalVideoDisc(title, category, director, length, cost);
                    } else if (!director.isEmpty()) {
                        dvd = new DigitalVideoDisc(title, category, director, cost);
                    } else if (!category.isEmpty() || cost > 0.0) {
                        dvd = new DigitalVideoDisc(title, category, cost);
                    } else {
                        dvd = new DigitalVideoDisc(title);
                    }

                    store.addMedia(dvd);
                    JOptionPane.showMessageDialog(AddDigitalVideoDiscToStoreScreen.this, "Added new DVD successfully!");

                    tfTitle.setText("");
                    tfCategory.setText("");
                    tfDirector.setText("");
                    tfLength.setText("");
                    tfCost.setText("");

                } catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AddDigitalVideoDiscToStoreScreen.this, "Length must be an Integer and Cost must be a Double!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(AddDigitalVideoDiscToStoreScreen.this, "There is an error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        center.add(btnAdd);

        return center;
    }
}
