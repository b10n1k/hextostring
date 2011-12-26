/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hextostring;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author j0ni
 */
public class UIconverter extends JFrame{
    
    
    public UIconverter(){
        super("Hex Converter");
        //this.title=new JLabel("Hex Converter");
       // this.title.setAlignmentX(TOP_ALIGNMENT);
        this.execution=new JButton("convert");
       // this.execution.setBounds(5, 5, 5, 5);
        this.argfield = new JTextField(20);
        this.display = new JTextArea(">>");
        
        this.execution.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) {
                display.append(">>>");
                String[] arguments=argfield.getText().split(" ");
                try {
                    String convert = Hextostring.convert(arguments);
                    display.setText(convert+"\n");
                    
                } catch (IOException ex) {
                    display.setText("No Conversion");
                }
            }
            
        });
        
        this.display=new JTextArea(25,20);
        //add(this.title,BorderLayout.NORTH);
        add(this.display,BorderLayout.CENTER);
        add(this.execution,BorderLayout.SOUTH);
        add(this.argfield,BorderLayout.NORTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    private JTextArea display;
    private JButton execution;
    private JLabel title;
    private JTextField argfield;
    
}
