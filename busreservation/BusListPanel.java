package busreservation;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BusListPanel extends JFrame {

    public BusListPanel(JFrame parentFrame, ArrayList<Bus> buses) {
        setTitle("Available Buses");
        setSize(400, 300);
        setLayout(new BorderLayout());

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Bus bus : buses) {
            listModel.addElement(bus.getBusInfo());
        }

        JList<String> busList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(busList);
        add(scrollPane, BorderLayout.CENTER);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());
        add(closeButton, BorderLayout.SOUTH);

        setLocationRelativeTo(parentFrame);
        setVisible(true);
    }
}
