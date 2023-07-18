import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class MainGUI extends JFrame {
    private JComboBox<String> searchComboBox;
    private JComboBox<String> sortComboBox;
    private JTextField sizeTextField;
    private JTextField elementsTextField;
    private JTextField targetTextField;
    private JTextArea resultTextArea;

    public MainGUI() {
        // Set up the main frame
        setTitle("Search and Sort Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new BorderLayout());

        // Create the panel to hold input components
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));

        // Search method selection
        JLabel searchLabel = new JLabel("Search Method:");
        searchComboBox = new JComboBox<>(new String[]{"Linear Search", "Binary Search"});
        inputPanel.add(searchLabel);
        inputPanel.add(searchComboBox);

        // Sort method selection
        JLabel sortLabel = new JLabel("Sort Method:");
        sortComboBox = new JComboBox<>(new String[]{"Bubble Sort", "Selection Sort"});
        inputPanel.add(sortLabel);
        inputPanel.add(sortComboBox);

        // Size input
        JLabel sizeLabel = new JLabel("Size:");
        sizeTextField = new JTextField();
        inputPanel.add(sizeLabel);
        inputPanel.add(sizeTextField);

        // Elements input
        JLabel elementsLabel = new JLabel("Elements:");
        elementsTextField = new JTextField();
        inputPanel.add(elementsLabel);
        inputPanel.add(elementsTextField);

        // Target input
        JLabel targetLabel = new JLabel("Target:");
        targetTextField = new JTextField();
        inputPanel.add(targetLabel);
        inputPanel.add(targetTextField);

        // Execute button
        JButton executeButton = new JButton("Execute");
        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperations();
            }
        });
        inputPanel.add(executeButton);

        // Add the input panel to the main frame
        add(inputPanel, BorderLayout.NORTH);

        // Result text area
        resultTextArea = new JTextArea();
        add(new JScrollPane(resultTextArea), BorderLayout.CENTER);

        // Make the main frame visible
        setVisible(true);
    }

    private void performOperations() {
        String searchMethod = (String) searchComboBox.getSelectedItem();
        String sortMethod = (String) sortComboBox.getSelectedItem();
        int size = Integer.parseInt(sizeTextField.getText());
        String[] elements = elementsTextField.getText().split(",");
        int target = Integer.parseInt(targetTextField.getText());

        String searchResult = performSearching(searchMethod, size, elements, target);
        String sortResult = performSorting(sortMethod, size, elements);

        String result = "Search Result:\n" + searchResult + "\n\nSort Result:\n" + sortResult;
        resultTextArea.setText(result);
    }

    private String performSearching(String searchMethod, int size, String[] elements, int target) {
        // Perform the searching operation based on the selected searchMethod, size, elements, and target
        // Replace the following placeholder code with your actual searching implementation
        long startTime = System.nanoTime(); // Start time
        if (searchMethod.equals("Linear Search")) {
            for (int i = 0; i < size; i++) {
                if (Integer.parseInt(elements[i]) == target) {
                    long endTime = System.nanoTime(); // End time
                    long executionTime = endTime - startTime;
                    return "Element found at index " + i + "\nTime Complexity: O(n)\nArray: " + Arrays.toString(elements) + "\nExecution Time: " + executionTime + " nanoseconds";
                }
            }
            long endTime = System.nanoTime(); // End time
            long executionTime = endTime - startTime;
            return "Element not found\nTime Complexity: O(n)\nArray: " + Arrays.toString(elements) + "\nExecution Time: " + executionTime + " nanoseconds";
        } else if (searchMethod.equals("Binary Search")) {
            // Implement binary search algorithm here
            // ...
            long endTime = System.nanoTime(); // End time
            long executionTime = endTime - startTime;
            return "Binary search result\nTime Complexity: O(log n)\nArray: " + Arrays.toString(elements) + "\nExecution Time: " + executionTime + " nanoseconds";
        } else {
            return "Invalid search method";
        }
    }

    private String performSorting(String sortMethod, int size, String[] elements) {
        // Perform the sorting operation based on the selected sortMethod, size, and elements
        // Replace the following placeholder code with your actual sorting implementation
        long startTime = System.nanoTime(); // Start time
        if (sortMethod.equals("Bubble Sort")) {
            // Implement bubble sort algorithm here
            // ...
            long endTime = System.nanoTime(); // End time
            long executionTime = endTime - startTime;
            return "Bubble sort result\nTime Complexity: O(n^2)\nArray: " + Arrays.toString(elements) + "\nExecution Time: " + executionTime + " nanoseconds";
        } else if (sortMethod.equals("Selection Sort")) {
            // Implement selection sort algorithm here
            // ...
            long endTime = System.nanoTime(); // End time
            long executionTime = endTime - startTime;
            return "Selection sort result\nTime Complexity: O(n^2)\nArray: " + Arrays.toString(elements) + "\nExecution Time: " + executionTime + " nanoseconds";
        } else if (sortMethod.equals("Insertion Sort")) {
            // Implement insertion sort algorithm here
            // ...
            long endTime = System.nanoTime(); // End time
            long executionTime = endTime - startTime;
            return "Insertion sort result\nTime Complexity: O(n^2)\nArray: " + Arrays.toString(elements) + "\nExecution Time: " + executionTime + " nanoseconds";
        }
        else {
            return "Invalid sort method";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainGUI();
            }
        });
    }
}
