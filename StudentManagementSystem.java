import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StudentManagementSystem {
    private static ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(null);

        // Create labels
        JLabel rollNumberLabel = new JLabel("Roll Number:");
        rollNumberLabel.setForeground(Color.WHITE);
        rollNumberLabel.setBounds(20, 20, 100, 30);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setBounds(20, 60, 100, 30);

        JLabel gradeLabel = new JLabel("Grade:");
        gradeLabel.setForeground(Color.WHITE);
        gradeLabel.setBounds(20, 100, 100, 30);

        // Create text fields
        JTextField rollNumberField = new JTextField();
        rollNumberField.setBounds(150, 20, 200, 30);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 60, 200, 30);

        JTextField gradeField = new JTextField();
        gradeField.setBounds(150, 100, 200, 30);

        // Create a message label to display information
        JLabel messageLabel = new JLabel("");
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setBounds(20, 270, 400, 30);

        // Create buttons
        JButton addButton = new JButton("Add Student");
        addButton.setBounds(50, 150, 140, 30);

        JButton removeButton = new JButton("Remove Student");
        removeButton.setBounds(200, 150, 140, 30);

        JButton searchButton = new JButton("Search Student");
        searchButton.setBounds(50, 200, 140, 30);

        JButton displayButton = new JButton("Display All Students");
        displayButton.setBounds(200, 200, 140, 30);

        // Add button action listeners
        addButton.addActionListener(e -> {
            String rollNumber = rollNumberField.getText();
            String name = nameField.getText();
            String grade = gradeField.getText();
            studentList.add(new Student(rollNumber, name, grade));
            messageLabel.setText("Student added successfully.");
            clearFields(rollNumberField, nameField, gradeField);
        });

        removeButton.addActionListener(e -> {
            String rollNumber = rollNumberField.getText();
            boolean found = false;
            for (Student student : studentList) {
                if (student.getRollNumber().equals(rollNumber)) {
                    studentList.remove(student);
                    messageLabel.setText("Student removed successfully.");
                    found = true;
                    break;
                }
            }
            if (!found) {
                messageLabel.setText("Student not found.");
            }
            clearFields(rollNumberField, nameField, gradeField);
        });

        searchButton.addActionListener(e -> {
            String rollNumber = rollNumberField.getText();
            boolean found = false;
            for (Student student : studentList) {
                if (student.getRollNumber().equals(rollNumber)) {
                    messageLabel.setText("Student Found: " + student);
                    found = true;
                    break;
                }
            }
            if (!found) {
                messageLabel.setText("No search found.");
            }
            clearFields(rollNumberField, nameField, gradeField);
        });

        displayButton.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            for (Student student : studentList) {
                sb.append(student).append("\n");
            }
            if (sb.length() > 0) {
                JOptionPane.showMessageDialog(frame, sb.toString(), "All Students", JOptionPane.INFORMATION_MESSAGE);
            } else {
                messageLabel.setText("No students to display.");
            }
        });

        // Add components to frame
        frame.add(rollNumberLabel);
        frame.add(nameLabel);
        frame.add(gradeLabel);
        frame.add(rollNumberField);
        frame.add(nameField);
        frame.add(gradeField);
        frame.add(addButton);
        frame.add(removeButton);
        frame.add(searchButton);
        frame.add(displayButton);
        frame.add(messageLabel);

        frame.getContentPane().setBackground(Color.BLACK);
        frame.setVisible(true);
    }

    private static void clearFields(JTextField rollNumberField, JTextField nameField, JTextField gradeField) {
        rollNumberField.setText("");
        nameField.setText("");
        gradeField.setText("");
    }

    static class Student {
        private String rollNumber;
        private String name;
        private String grade;

        public Student(String rollNumber, String name, String grade) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.grade = grade;
        }

        public String getRollNumber() {
            return rollNumber;
        }

        @Override
        public String toString() {
            return "Roll Number: " + rollNumber + ", Name: " + name + ", Grade: " + grade;
        }
    }
}
