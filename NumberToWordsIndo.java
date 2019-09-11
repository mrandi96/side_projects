import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.math.*;

import java.awt.event.*;

/**
 * EndGoals
 */
public class NumberToWordsIndo extends JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 6678784271033939682L;
    int height = 550, width = height * 16 / 9;
    JFrame frame = new JFrame("Angka ke Kalimat");
    JLabel label; JFormattedTextField textField; JTextArea textArea; 

    String translator10(int number) {
        if(number == 1) return "Satu ";
        if(number == 2) return "Dua ";
        if(number == 3) return "Tiga ";
        if(number == 4) return "Empat ";
        if(number == 5) return "Lima ";
        if(number == 6) return "Enam ";
        if(number == 7) return "Tujuh ";
        if(number == 8) return "Delapan ";
        if(number == 9) return "Sembilan ";
        if(number == 10) return "Sepuluh ";
        if(number == 11) return "Sebelas ";
        if(number == 12) return "Dua Belas ";
        if(number == 13) return "Tiga Belas ";
        if(number == 14) return "Empat Belas ";
        if(number == 15) return "Lima Belas ";
        if(number == 16) return "Enam Belas ";
        if(number == 17) return "Tujuh Belas ";
        if(number == 18) return "Delapan Belas ";
        if(number == 19) return "Sembilan Belas ";
        return "";
    }

    String translators(String number1){
        BigInteger number = new BigInteger(number1), temp = number;
        var word = "";
        if(number.equals(new BigInteger("0"))){
            return "Nol";
        }
        if(number.compareTo(new BigInteger("10").pow(48)) >= 0){
            word += translator(number.divide(new BigInteger("10").pow(48)).intValue())+ "Kuindesiliun ";
            number = number.mod(new BigInteger("10").pow(48));
        }
        if(number.compareTo(new BigInteger("10").pow(45)) >= 0){
            word += translator(number.divide(new BigInteger("10").pow(45)).intValue())+ "Kuatuordesiliun ";
            number = number.mod(new BigInteger("10").pow(45));
        }
        if(number.compareTo(new BigInteger("10").pow(42)) >= 0){
            word += translator(number.divide(new BigInteger("10").pow(42)).intValue())+ "Tredesiliun ";
            number = number.mod(new BigInteger("10").pow(42));
        }
        if(number.compareTo(new BigInteger("10").pow(39)) >= 0){
            word += translator(number.divide(new BigInteger("10").pow(39)).intValue())+ "Duodesiliun ";
            number = number.mod(new BigInteger("10").pow(39));
        }
        if(number.compareTo(new BigInteger("10").pow(36)) >= 0){
            word += translator(number.divide(new BigInteger("10").pow(36)).intValue())+ "Undesiliun ";
            number = number.mod(new BigInteger("10").pow(36));
        }
        if(number.compareTo(new BigInteger("10").pow(33)) >= 0){
            word += translator(number.divide(new BigInteger("10").pow(33)).intValue())+ "Desiliun ";
            number = number.mod(new BigInteger("10").pow(33));
        }
        if(number.compareTo(new BigInteger("10").pow(30)) >= 0){
            word += translator(number.divide(new BigInteger("10").pow(30)).intValue())+ "Noniliun ";
            number = number.mod(new BigInteger("10").pow(30));
        }
        if(number.compareTo(new BigInteger("10").pow(27)) >= 0){
            word += translator(number.divide(new BigInteger("10").pow(27)).intValue())+ "Oktiliun ";
            number = number.mod(new BigInteger("10").pow(27));
        }
        if(number.compareTo(new BigInteger("10").pow(24)) >= 0){
            word += translator(number.divide(new BigInteger("10").pow(24)).intValue())+ "Septiliun ";
            number = number.mod(new BigInteger("10").pow(24));
        }
        if(number.compareTo(new BigInteger("10").pow(21)) >= 0){
            word += translator(number.divide(new BigInteger("10").pow(21)).intValue())+ "Sekstiliun ";
            number = number.mod(new BigInteger("10").pow(21));
        }
        if(number.compareTo(new BigInteger("10").pow(18)) >= 0){
            word += translator(number.divide(new BigInteger("10").pow(18)).intValue())+ "Kuintiliun ";
            number = number.mod(new BigInteger("10").pow(18));
        }
        if(number.compareTo(new BigInteger("10").pow(15)) >= 0){
            word += translator(number.divide(new BigInteger("10").pow(15)).intValue())+ "Kuadriliun ";
            number = number.mod(new BigInteger("10").pow(15));
        }
        if(number.compareTo(new BigInteger("10").pow(12)) >= 0){
            word += translator(number.divide(new BigInteger("10").pow(12)).intValue())+ "Triliun ";
            number = number.mod(new BigInteger("10").pow(12));
        }
        if(number.compareTo(new BigInteger("10").pow(9)) >= 0){
            word += translator(number.divide(new BigInteger("10").pow(9)).intValue())+ "Miliar ";
            number = number.mod(new BigInteger("10").pow(9));
        }
        if(number.compareTo(new BigInteger("10").pow(6)) >= 0){
            word += translator(number.divide(new BigInteger("10").pow(6)).intValue())+ "Juta ";
            number = number.mod(new BigInteger("10").pow(6));
        }
        int number2 = number.intValue();
        if(number2 >= 1000){
            if(1000 <= number2 && number2 < 2000 && temp.compareTo(new BigInteger("2000")) == -1){
                word += "Seribu ";
            }
            else{
            word += translator(number.divide(new BigInteger("1000")).intValue()) + "Ribu ";
            }
            number = number.mod(new BigInteger("1000"));
        }
        return word += translator(number.intValue());
    }

    String translator(int number){
        String word = "";
        if(number >= 100){
            if(100 <= number && number < 200){
                word += "Seratus ";
            }
            else{
            word += translator10(number / 100) + "Ratus ";
            }
            number%=100;
        }
        if(number >= 20){ 
            word += translator10(number / 10) + "Puluh ";
            number%=10;
        }
        return word += translator10(number);
    }

    NumberToWordsIndo(){
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setLayout(null);
        frame.setLocation(250, 100);
        frame.setResizable(false);
        frame.setVisible(true);
        
        label = new JLabel("Masukkan angka: ");
        label.setFont(label.getFont().deriveFont(17f));
        frame.add(label);
        label.setBounds(30, 20, 175, 40);

        textField = new JFormattedTextField();
        frame.add(textField);
        textField.setHorizontalAlignment(JFormattedTextField.RIGHT);
        textField.setBounds(225, 20, 720, 40);
        textField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        textField.setFont(textField.getFont().deriveFont(17f));
        textField.getDocument().addDocumentListener(new DocumentListener(){
        
            @Override
            public void removeUpdate(DocumentEvent arg0) {
                try {
                    set();
                } catch (Exception e) {
                    textArea.setText("");
                }
            }
        
            @Override
            public void insertUpdate(DocumentEvent arg0) {
                try {
                    set();
                } catch (Exception e) {
                    textArea.setText("Masukkan angka!!!");
                }
            }
        
            @Override
            public void changedUpdate(DocumentEvent arg0) {
                try {
                    set();
                } catch (Exception e) {
                    textArea.setText("");
                }
            }
        });

        textArea = new JTextArea();
        frame.add(textArea);
        textArea.setBounds(30, 80, 915, 390);
        textArea.setFont(textArea.getFont().deriveFont(27f));
        textArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        
    }
    public static void main(String[] args) {
       new NumberToWordsIndo();
    }

    public void set(){
        textArea.setText(translators(textField.getText()));
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

    }
}
