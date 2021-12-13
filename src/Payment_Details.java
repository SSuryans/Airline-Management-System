import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Payment_Details extends JFrame {
    JTextField textfield;
    JTable table;
    JLabel Sector;
    JLabel FlightCode,Capacity,Classcode,Classname,label;

    public static void main (String[] args){
        new Payment_Details();
    }
    public Payment_Details(){
        initialize();
    }
    private void initialize(){
        setTitle("PAYMENT DETAILS");;
        getContentPane().setBackground(Color.WHITE);
        setSize(860,486);
        setLayout(null);

        JLabel Fcode = new JLabel("PNR NO");
        Fcode.setFont(new Font("Tahoma",Font.PLAIN,17));
        Fcode.setBounds(60,160,150,26);
        add(Fcode);

        textfield = new JTextField();
        textfield.setBounds(200,160,150,26);
        add(textfield);

        table = new JTable();
        table.setBounds(45,329,766,87);
        add(table);

        JButton Show = new JButton("SHOW");
        Show.setFont(new Font("Tahoma",Font.PLAIN,17));
        Show.setBackground(Color.BLACK);
        Show.setForeground(Color.WHITE);
        Show.setBounds(200,210,150,26);
        add(Show);

        Sector = new JLabel("PAYMENT DETAILS");
        Sector.setForeground(Color.BLUE);
        Sector.setFont(new Font("Tahoma",Font.PLAIN,31));
        Sector.setBounds(51,17,300,39);
        add(Sector);

        FlightCode = new JLabel("PNR_NO");
        FlightCode.setFont(new Font("Tahoma",Font.PLAIN,13));
        FlightCode.setBounds(84,292,108,26);
        add(FlightCode);

        Capacity = new JLabel("PAID_AMOUNT");
        Capacity.setFont(new Font("Tahoma",Font.PLAIN,13));
        Capacity.setBounds(183,298,92,14);
        add(Capacity);

        Classcode = new JLabel();
        Classcode.setFont(new Font("Tahoma",Font.PLAIN,13));
        Classcode.setBounds(322,294,101,24);
        add(Classcode);

        Classname = new JLabel("CHEQUE_NO");
        Classname.setFont(new Font("Tahoma",Font.PLAIN,13));
        Classname.setBounds(455,298,114,14);
        add(Classname);

        label=new JLabel("");
        label.setIcon(new ImageIcon(ClassLoader.getSystemResource("images/payment.png")));
        label.setBounds(425,15,239,272);
        add(label);

        JLabel Cardno = new JLabel("CARD_NO");
        Cardno.setFont(new Font("Tahoma",Font.PLAIN,13));
        Cardno.setBounds(602,299,101,19);
        add(Cardno);

        JLabel Phoneno = new JLabel("PHONE_NO");
        Phoneno.setFont(new Font("Tahoma",Font.PLAIN,13));
        Phoneno.setBounds(712,294,86,24);
        add(Phoneno);

        setVisible(true);

        Show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                    String code = textfield.getText();

                    conn c = new conn();
                    String str = "SELECT pnr_no,paid_amt,pay_date,cheque_no,card_no,ph_no from payment where pnr_no = '"+code+"'";

                    ResultSet rs = c.s.executeQuery(str);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        setSize(960,590);
        setLocation(400,200);
        setVisible(true);
    }
}
