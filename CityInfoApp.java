import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class CityInfoApp extends JFrame {
    
    private JList<String> cityList;
    private JLabel infoLabel;
    
    // Create a map to hold city information
    private Map<String, String> cityInfo;

    public CityInfoApp() {
        // Initialize city information
        cityInfo = new HashMap<>();
        cityInfo.put("Delhi", "Country: India\nPopulation: 30 million");
        cityInfo.put("Hyderabad", "Country: India\nPopulation: 10 million");
        cityInfo.put("Kolkata", "Country: India\nPopulation: 15 million");
        cityInfo.put("Mumbai", "Country: India\nPopulation: 20 million");

        // Set up the frame
        setTitle("City Information");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the list of cities
        String[] cities = {"Delhi", "Hyderabad", "Kolkata", "Mumbai"};
        cityList = new JList<>(cities);
        cityList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Add a selection listener to update city information on selection
        cityList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String selectedCity = cityList.getSelectedValue();
                if (selectedCity != null) {
                    infoLabel.setText("<html>" + cityInfo.get(selectedCity).replace("\n", "<br>") + "</html>");
                }
            }
        });

        // Add the city list to a scroll pane and add it to the frame
        JScrollPane scrollPane = new JScrollPane(cityList);
        add(scrollPane, BorderLayout.WEST);

        // Create the label to display city information
        infoLabel = new JLabel("Select a city to see information.");
        add(infoLabel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CityInfoApp app = new CityInfoApp();
            app.setVisible(true);
        });
    }
}
