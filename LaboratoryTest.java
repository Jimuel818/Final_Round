import javax.swing.*;
import java.awt.*;

public class LaboratoryTest extends JFrame {
    JTextField nameIn, ageIn, resultIn;
    JComboBox<String> sexIn, testIn;
    JTextArea rep_area;
    ChemistryTest manager;

    public LaboratoryTest() {
        manager = new ChemistryTest();


        //Java gui, inputs,buttons and design
        
        setTitle("Clinical Chemistry Diagnostic");
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        
        add(new JLabel("Name:"));
        nameIn = new JTextField(15); add(nameIn);

        add(new JLabel("Age:"));
        ageIn = new JTextField(5); add(ageIn);

        add(new JLabel("Sex:"));
        sexIn = new JComboBox<>(new String[]{"Male", "Female"}); add(sexIn);

        add(new JLabel("Test:"));
        testIn = new JComboBox<>(new String[]{
                "FBS",
                "RBS",
                "Total Cholesterol",
                "HDL",
                "LDL",
                "Triglycerides",
                "Creatinine",
                "Uric Acid",
                "BUN",
                "AST",
                "ALT",
                "Sodium",
                "Potassium",
                "Chloride",
                "Total Calcium",
                "Ionized Calcium"
        }); 
        add(testIn);

        add(new JLabel("Result:"));
        resultIn = new JTextField(10); add(resultIn);

        JButton runBtn = new JButton("Run Test");
        add(runBtn);

        JButton clearBtn = new JButton("Clear");
        add(clearBtn);
        rep_area = new JTextArea(20, 30);
        rep_area.setEditable(false);
        add(new JScrollPane(rep_area));

        // GUI of colors, texts and buttons
        getContentPane().setBackground(Color.BLACK);

        Color fgColor = Color.white;
        Color bgColor = Color.BLACK;

        nameIn.setBackground(bgColor);
        nameIn.setForeground(fgColor);
        nameIn.setCaretColor(fgColor);

        ageIn.setBackground(bgColor);
        ageIn.setForeground(fgColor);
        ageIn.setCaretColor(fgColor);

        sexIn.setBackground(bgColor);
        sexIn.setForeground(fgColor);

        testIn.setBackground(bgColor);
        testIn.setForeground(fgColor);

        resultIn.setBackground(bgColor);
        resultIn.setForeground(fgColor);
        resultIn.setCaretColor(fgColor);

        rep_area.setBackground(bgColor);
        rep_area.setForeground(fgColor);
        rep_area.setCaretColor(fgColor);

        runBtn.setBackground(Color.green);
        runBtn.setForeground(Color.BLACK);

        clearBtn.setBackground(Color.red);
        clearBtn.setForeground(Color.BLACK);

    
        for (Component comp : getContentPane().getComponents()) {
            if (comp instanceof JLabel) {
                comp.setForeground(fgColor);
            }
        }

        runBtn.addActionListener(e -> {
            try {
                //this block of code Create a Patient record using the inputs provided by the user
                Patient p = new Patient(nameIn.getText(), Integer.parseInt(ageIn.getText()), (String)sexIn.getSelectedItem());
                
                //Create Test based on chosen test of the user
                LabTest test;
                String sel = (String)testIn.getSelectedItem();

                //test selection based on the users choice
                if (sel == "FBS") {
                    test = new FastingBloodSugar();
                } else if (sel == "RBS") {
                    test = new RandomBloodSugar();
                } else if (sel == "Total Cholesterol") {
                    test = new TotalCholesterol();
                } else if (sel == "HDL") {
                    test = new HDL();
                } else if (sel == "LDL") {
                    test = new LDL();
                } else if (sel == "Triglycerides") {
                    test = new Triglycerides();
                } else if (sel == "Creatinine") {
                    test = new Creatinine();
                } else if (sel == "Uric Acid") {
                    test = new UricAcid();
                } else if (sel == "BUN") {
                    test = new BUN();
                } else if (sel == "AST") {
                    test = new AST();
                }else if (sel == "ALT") {
                    test = new ALT();
                } else if (sel == "Sodium") {
                    test = new Sodium();
                } else if (sel == "Potassium") {
                    test = new Potassium();
                } else if (sel == "Chloride") {
                    test = new Chloride();
                } else if (sel == "Total Calcium") {
                    test = new TotalCalcium();
                } else {
                    test = new IonizedCalcium();
                }
                

                test.setResult(Double.parseDouble(resultIn.getText()));
                manager.addTest(test);



                // this block of is code to show outputs
                rep_area.append("==========Laboratory Report==========\n");
                rep_area.append("Patient         :" + p.name + "\n");
                rep_area.append("Test            :" + test.testName + "\n");
                rep_area.append("Result          :" + test.result + " " + test.unit + "\n");
                rep_area.append("Reference Range :" + test.getRangeString(p.sex) + "\n");
                rep_area.append("Status          :" + test.evaluate(p.sex) + "\n");
                rep_area.append("=================================\n");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid Input!");
            }
        });
        //resets the system if the user want to try again

        clearBtn.addActionListener(e -> {
            nameIn.setText(""); ageIn.setText(""); resultIn.setText(""); rep_area.setText("");
            manager.clear();
        });
    }

    public static void main(String[] args) {
        new LaboratoryTest().setVisible(true);
    }
}
