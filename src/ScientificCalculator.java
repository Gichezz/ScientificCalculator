import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ScientificCalculator extends JFrame implements ActionListener {

    private String[] btnLabels = {
            "(", ")", "mc", "m+", "m-", "mr", "C", "+/-", "%", "÷",
            "2ⁿᵈ", "x²", "x³", "xʸ", "eˣ", "10ˣ", "7", "8", "9", "x",
            "1/x", "²√x", "³√x", "ʸ√x", "ln", "log₁₀", "4", "5", "6", "-",
            "x!", "sin", "cos", "tan", "e", "EE", "1", "2", "3", "+",
            "Rad", "sinh", "cosh", "tanh", "π", "Rand", "0","", ".", "="
    };
    private int operator = 0;
    private JPanel panel = new JPanel(new BorderLayout(5, 5));
    private JPanel btnPanel = new JPanel(new GridLayout(5, 10, 2, 2));
    private JButton[] btns = new JButton[50];
    private JTextField display = new JTextField();
    private double firstNumber = 0;
    private double  secondNumber = 0;
    private int mode = 1;


    public ScientificCalculator() {
        calculatorLayout();
    }

    private void calculatorLayout() {
        display.setFont(new Font("Helvetica", Font.PLAIN, 50));
        setTitle("Calculator");
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setBorder(null);
        display.setPreferredSize(new Dimension(300,120));

        display.setBackground(new Color(36,36,36));
        panel.setBackground(new Color(36,36,36));
        btnPanel.setBackground(new Color(36,36,36));
        display.setForeground(Color.WHITE);

        for (int i = 0; i < btns.length; i++) {
            btns[i] = new JButton(btnLabels[i]);
            btns[i].setFont(new Font("Helvetica", Font.PLAIN, 18));
            btns[i].setOpaque(true);
            btns[i].setBorderPainted(false);
            btns[i].setBackground(new Color(68,68,68));
            btns[i].setForeground(Color.WHITE);
            btns[i].addActionListener(this);
            btnPanel.add(btns[i]);
        }
        btns[18].setBackground(new Color(102,102,102));
        btns[17].setBackground(new Color(102,102,102));
        btns[16].setBackground(new Color(102,102,102));
        btns[28].setBackground(new Color(102,102,102));
        btns[27].setBackground(new Color(102,102,102));
        btns[26].setBackground(new Color(102,102,102));
        btns[38].setBackground(new Color(102,102,102));
        btns[37].setBackground(new Color(102,102,102));
        btns[36].setBackground(new Color(102,102,102));
        btns[48].setBackground(new Color(102,102,102));
        btns[47].setBackground(new Color(102,102,102));
        btns[46].setBackground(new Color(102,102,102));
        btns[9].setBackground(new Color(255,149,0));
        btns[19].setBackground(new Color(255,149,0));
        btns[29].setBackground(new Color(255,149,0));
        btns[39].setBackground(new Color(255,149,0));
        btns[49].setBackground(new Color(255,149,0));

        panel.add(btnPanel, BorderLayout.CENTER);
        panel.add(display, BorderLayout.NORTH);
        display.setEditable(false);
        add(panel);
        setSize(850, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ScientificCalculator::new);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String command = e.getActionCommand().toString();

            switch (command) {
                case ".":
                    if (!display.getText().contains(".")) {
                        display.setText(display.getText() + ".");
                    }
                    break;
                case "0":
                    display.setText(display.getText() + "0");
                    break;
                case "1":
                    display.setText(display.getText() + "1");
                    break;
                case "2":
                    display.setText(display.getText() + "2");
                    break;
                case "3":
                    display.setText(display.getText() + "3");
                    break;
                case "4":
                    display.setText(display.getText() + "4");
                    break;
                case "5":
                    display.setText(display.getText() + "5");
                    break;
                case "6":
                    display.setText(display.getText() + "6");
                    break;
                case "7":
                    display.setText(display.getText() + "7");
                    break;
                case "8":
                    display.setText(display.getText() + "8");
                    break;
                case "9":
                    display.setText(display.getText() + "9");
                    break;
                case "(":
                    display.setText(display.getText() + "(");
                    break;
                case ")":
                    display.setText(display.getText() + ")");
                    break;

                case "π":
                    display.setText(display.getText() + Math.PI);
                    break;
                case "e":
                    display.setText(display.getText() + Math.exp(1));
                    break;
                case "Rand":
                    display.setText(display.getText() + Math.random());
                    break;

                case "+":
                    if (!display.getText().isEmpty()) {
                        firstNumber = Double.parseDouble(display.getText().toString());
                        operator = 1;
                        display.setText("");
                    }
                    break;
                case "-":
                    if (!display.getText().isEmpty()) {
                        firstNumber = Double.parseDouble(display.getText().toString());
                        operator = 2;
                        display.setText("");
                    }
                    break;
                case "x":
                    if (!display.getText().isEmpty()) {
                        firstNumber = Double.parseDouble(display.getText().toString());
                        operator = 3;
                        display.setText("");
                    }
                    break;
                case "÷":
                    if (!display.getText().isEmpty()) {
                        firstNumber = Double.parseDouble(display.getText().toString());
                        operator = 4;
                        display.setText("");
                    }
                    break;
                case "xʸ":
                    if (!display.getText().isEmpty()) {
                        firstNumber = Double.parseDouble(display.getText().toString());
                        operator = 5;
                        display.setText("");
                    }
                    break;
                case "ʸ√x":
                    if (!display.getText().isEmpty()) {
                        firstNumber = Double.parseDouble(display.getText().toString());
                        operator = 6;
                        display.setText("");
                    }
                    break;

                case "%":
                    double num = Double.parseDouble(display.getText().toString());
                    display.setText(String.valueOf(num / 100.0));
                    break;
                case "+/-":
                    double neg = Double.parseDouble(display.getText().toString());
                    neg *= -1;
                    display.setText(String.valueOf(neg));
                    break;
                case "x!":
                    double currentInput = Double.parseDouble(display.getText().toString());
                    int fact = 1;
                    for(int i=1;i<=currentInput;i++){
                        fact = fact*i;
                    }
                    display.setText(String.valueOf(fact));
                    break;
                case "C":
                    display.setText("");
                    break;

                case "EE":
                    if (!display.getText().isEmpty()) {
                        firstNumber = Double.parseDouble(display.getText().toString());
                        operator = 7;
                        display.setText("");
                    }
                    break;

                case "2ⁿᵈ":
                    mode=(mode==1)?2:1;
                    updateButtonLabels();
                    break;
                case "sin":
                    additionalOperations("sin");
                    break;
                case "sin⁻¹":
                    additionalOperations("sin⁻¹");
                    break;
                case "cos":
                    additionalOperations("cos");
                    break;
                case "cos⁻¹":
                    additionalOperations("cos⁻¹");
                    break;
                case "tan":
                    additionalOperations("tan");
                    break;
                case "tan⁻¹":
                    additionalOperations("tan⁻¹");
                    break;

                case "²√x", "x²", "x³", "³√x", "10ˣ", "1/x",
                        "log₁₀", "ln", "eˣ", "sinh", "cosh", "tanh":
                    additionalOperations(command);
                    break;
                default:
            }

            if (command.equalsIgnoreCase("=")) {

                if (!display.getText().isEmpty()) {
                    secondNumber = Double.parseDouble(display.getText().toString());

                    switch (operator) {
                        case 1: // addition
                            display.setText(String.valueOf(firstNumber + secondNumber));
                            break;
                        case 2: // subtraction
                            display.setText(String.valueOf(firstNumber - secondNumber));
                            break;
                        case 3: // multiplication
                            display.setText(String.valueOf(firstNumber * secondNumber));
                            break;
                        case 4: // division
                            if (secondNumber != 0){
                                display.setText(String.valueOf(firstNumber / secondNumber));
                            }else {
                                throw new ArithmeticException("Cannot divide by zero");
                            }
                            break;
                        case 5: // xʸ
                            display.setText(String.valueOf(Math.pow(firstNumber, secondNumber)));
                            break;
                        case 6: // ʸ√x
                            display.setText(String.valueOf(Math.pow(firstNumber, (1 / secondNumber))));
                            break;
                        case 7: // EE
                            display.setText(String.valueOf(firstNumber * Math.pow(10, secondNumber)));
                            break;
                        default:
                    }
                }
            }
        }catch (NumberFormatException e1){
            display.setText("Error: Invalid input");
        }catch (ArithmeticException e2){
            display.setText("Error: " + e2.getMessage());
        }
    }

    private void additionalOperations(String operation) {
        try {
            if (!display.getText().isEmpty()) {
                double currentInput = Double.parseDouble(display.getText().toString());
                double result = 0;
                double radian = (currentInput * (Math.PI / 180));

                switch (operation) {
                    case "sin":
                        result = Math.sin(radian);
                        break;
                    case "cos":
                        result = Math.cos(radian);
                        break;
                    case "tan":
                        result = Math.tan(radian);
                        break;
                    case "x²":
                        result = Math.pow(currentInput, 2);
                        break;
                    case "²√x":
                        result = Math.sqrt(currentInput);
                        break;
                    case "x³":
                        result = Math.pow(currentInput, 3);
                        break;
                    case "³√x":
                        result = Math.cbrt(currentInput);
                        break;
                    case "10ˣ":
                        result = Math.pow(10, currentInput);
                        break;
                    case "eˣ":
                        result = Math.exp(currentInput);
                        break;
                    case "1/x":
                        if (currentInput != 0){
                            result = 1 / currentInput;
                        }else {
                            throw new ArithmeticException("Cannot divide by zero");
                        }
                        break;
                    case "log₁₀":
                        result = Math.log10(currentInput);
                        break;
                    case "ln":
                        result = Math.log(currentInput);
                        break;
                    case "sinh":
                        result = Math.sinh(currentInput);
                        break;
                    case "cosh":
                        result = Math.cosh(currentInput);
                        break;
                    case "tanh":
                        result = Math.tanh(currentInput);
                        break;
                    case "sin⁻¹":
                        result = Math.toDegrees(Math.asin(currentInput));
                        break;
                    case "cos⁻¹":
                        result = Math.toDegrees(Math.acos(currentInput));
                        break;
                    case "tan⁻¹":
                        result = Math.toDegrees(Math.atan(currentInput));
                        break;
                }
                display.setText(String.valueOf(result));
            }
        }catch (NumberFormatException e1){
            display.setText("Error: Invalid input");
        }catch (ArithmeticException e2){
            display.setText("Error:" + e2.getMessage());
        }
    }
    private void updateButtonLabels(){
        if (mode==2){
            btns[31].setText("sin⁻¹");
            btns[32].setText("cos⁻¹");
            btns[33].setText("tan⁻¹");
        }else{
            btns[31].setText("sin");
            btns[32].setText("cos");
            btns[33].setText("tan");
        }
    }
}
