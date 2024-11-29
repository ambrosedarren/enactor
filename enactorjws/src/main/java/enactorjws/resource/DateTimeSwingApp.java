package enactorjws.resource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

public class DateTimeSwingApp {
    public static void main(String[] args) {
        // Schedule the creation of the UI on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Date and Time Fetcher");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);
            frame.setLayout(new BorderLayout());

            // JLabel for displaying the date and time
            JLabel dateTimeLabel = new JLabel("Click the button to fetch the date and time.", SwingConstants.CENTER);
            dateTimeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            frame.add(dateTimeLabel, BorderLayout.CENTER);

            // JButton for making the request
            JButton fetchButton = new JButton("Fetch Date and Time");
            frame.add(fetchButton, BorderLayout.SOUTH);

            // Add ActionListener to the button
            fetchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        // Call the fetchDateTime method and update the label with the response
                        String response = fetchDateTime();
                        dateTimeLabel.setText("Current Date and Time: " + response);
                    } catch (Exception ex) {
                        dateTimeLabel.setText("Error: " + ex.getMessage());
                        ex.printStackTrace();
                    }
                }
            });

            // Make the frame visible
            frame.setVisible(true);
        });
    }

    /**
     * Fetches the current date and time from the REST API using Jersey Client.
     * @return The date and time as a String.
     * @throws Exception If there is an issue with the HTTP request.
     */
    private static String fetchDateTime() throws Exception {
        String serviceUrl = "http://localhost:8080/enactorjws/api/datetime/string"; // Endpoint URL

        // Use Jersey Client to create a client and make a GET request
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(serviceUrl);

        // Get the response as plain text
        String response = target.request(MediaType.TEXT_PLAIN).get(String.class);

        // Close the client (optional but good practice)
        client.close();

        return response;
    }
}
