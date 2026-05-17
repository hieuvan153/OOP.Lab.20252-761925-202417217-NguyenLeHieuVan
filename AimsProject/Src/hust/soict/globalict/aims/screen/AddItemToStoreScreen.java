package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;

    public AddItemToStoreScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Add Item to Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenuItem viewStoreMenu = new JMenuItem("View store");
        viewStoreMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StoreManagerScreen(store);
                dispose();
            }
        });
        menu.add(viewStoreMenu);

        JMenuItem smUpdateStore = new JMenu("Update Store");

        JMenuItem addBookMenu = new JMenuItem("Add Book");
        addBookMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBookToStoreScreen(store);
                dispose();
            }
        });
        smUpdateStore.add(addBookMenu);

        JMenuItem addCDMenu = new JMenuItem("Add CD");
        addCDMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddCompactDiscToStoreScreen(store);
                dispose();
            }
        });
        smUpdateStore.add(addCDMenu);

        JMenuItem addDVDMenu = new JMenuItem("Add DVD");
        addDVDMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDigitalVideoDiscToStoreScreen(store);
                dispose();
            }
        });
        smUpdateStore.add(addDVDMenu);

        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    abstract JPanel createCenter();
}
