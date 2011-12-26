 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hextostring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author j0ni
 */
public class Hextostring {

     static String ascii_ch_st = "41"; //65 
     static String ascii_ch_en = "7A"; //122
     
    private static boolean isFile(String string) {
        File file=new File(string);
        if(file.exists()) return true;
        return false;
    }

    private StringBuffer hex_text;
    private File hFile;
    
    public Hextostring(){
        this.hex_text=new StringBuffer();
        this.hFile=null;
    }
    
    public Hextostring(String hex[]){
        this.hex_text=new StringBuffer();
        int len=hex.length;
        for(int i=0;i<len;i++)
        this.hex_text.append(hex[i]+" ");
        System.out.println(this.hex_text);
    }
    
    public Hextostring(File hex){
        this.hFile=hex;
    }
    
    public char hexTo(String hex){
        char ntxt;
        int ascii=Integer.parseInt(hex, 16);
        //if(ascii >= Integer.parseInt(ascii_ch_st,16) && ascii <= Integer.parseInt(ascii_ch_en,16)){
        ntxt=(char)ascii;
        return ntxt;
       // }
       // else
      //  return ntxt=' ';
    }
    /**
     * @param args the command line arguments
     */
    public static String convert(String[] args) throws IOException {
        String sequence = " ";
        if(args.length<1){
            //System.err.println("Syntax: Hextotext [hex]");
            //System.exit(0);
            JOptionPane.showConfirmDialog(null, "Enter hex script", "Wrong Input", JOptionPane.OK_OPTION);
        }
        
        if(isFile(args[0])){
            File fhex=new File(args[0]);
            Hextostring tool=new Hextostring(fhex);
            sequence=tool.hfileTo(fhex);
        }
        else{
            Hextostring tool=new Hextostring(args);
            try{
              sequence=tool.txto(tool.hex_text.toString()); 
                System.out.println(sequence+"\n");
                } catch(NumberFormatException nfe){
                    System.out.println("nfe exception");
                
            }
        } 
        return sequence;
    }

    private String hfileTo(File file) {
        String cbuf = null;
        StringBuilder sequence = new StringBuilder();
        try{
            FileInputStream in=new FileInputStream(file);
            BufferedReader reader=new BufferedReader(new InputStreamReader(in));
            
            while((cbuf=reader.readLine())!=null){
                  String b[]=cbuf.split(" "); 
                for(int c=0;c<b.length;c++){
                    System.out.println((b[c])+" ");
                }  
                for(int c=0;c<b.length;c++){
                  sequence.append(hexTo(b[c]));
                }
            }
            
        }
        catch(IOException ex){
            System.out.println("hfileTo error"+ex.getMessage());
        }
        return sequence.toString();
    }
    
    private String txto(String str) throws IOException{
        String b[]=str.split(" "); 
        StringBuilder asc = new StringBuilder();
        for(int c=0;c<b.length;c++){
            asc.append(hexTo(b[c]));
                }
        return asc.toString();
    }
    
    public void  getParam(String param){
        System.out.print(param+"\n"); 
    }
}
