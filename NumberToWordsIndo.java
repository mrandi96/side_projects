import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.*;

/**
 * EndGoals
 */
public class EndGoals extends JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 6678784271033939682L;
    int height = 550, width = height * 16 / 9;
    JFrame frame = new JFrame("Angka ke Kalimat");
    JLabel label; JFormattedTextField textField; JTextArea textArea; 

    String translator10(long number) {
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

    String translators(long number){
        var word = "";
        long temp = number;
        if(number == 0){
            return "Nol";
        }
        if(number > 999999999999999999L){
            word += translator(number / 1000000000000000000L) + "Kuintiliun ";
            number%=1000000000000000000L;
        }
        if(number > 999999999999999L){
            word += translator(number / 1000000000000000L) + "Kuadriliun ";
            number%=1000000000000000L;
        }
        if(number > 999999999999L){
            word += translator(number / 1000000000000L) + "Triliun ";
            number%=1000000000000L;
        }
        if(number > 999999999){
            word += translator(number / 1000000000) + "Miliar ";
            number%=1000000000;
        }
        if(number > 999999){
            word += translator(number / 1000000) + "Juta ";
            number%=1000000;
        }
        if(number > 999){
            if(1000 <= number && number <= 1999 && temp <= 1999){
                word += "Seribu ";
            }
            else{
            word += translator(number / 1000) + "Ribu ";
            }
            number%=1000;
        }
        return word += translator(number);
    }
    //fungsi seribu dibuat di fungsi untuk seribuan, jutaan, miliaran, dst.
    String translator(long number){
        String word = "";
        if(number > 99){
            if(100 <= number && number <= 199){
                word += "Seratus ";
            }
            else{
            word += translator10(number / 100) + "Ratus ";
            }
            number%=100;
        }
        if(number > 19){ 
            word += translator10(number / 10) + "Puluh ";
            number%=10;
        }
        return word += translator10(number);
    }

    EndGoals(){
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
       new EndGoals();
    }

    public void set(){
        textArea.setText(translators(Long.parseLong(textField.getText())));
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

    }
}