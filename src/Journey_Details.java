import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Journey_Details extends JFrame {

    JTable table;
    JLabel ReservationDetails,pnr_no,ticket_id,f_code,jny_date,jny_time,src,dst,label,label1;

    public static void main(String [] args)
    {
        new Journey_Details();
    }
    public Journey_Details(){
        setTitle("JOURNEY DETAILS");
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);

        src = new JLabel("SOURCE");
        src.setFont(new Font("Tahoma",Font.PLAIN,19));
        src.setBounds(60,100,150,27);
        add(src);

        dst = new JLabel("DESTINATION");
        dst.setFont(new Font("Tahoma",Font.PLAIN,19));
        dst.setBounds(350,100,150,27);
        add(dst);

        JButton show = new JButton("SHOW");
        show.setBounds(680,100,100,30);
        add(show);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        ReservationDetails = new JLabel("JOURNEY DETAILS");
        ReservationDetails.setForeground(Color.BLUE);
        ReservationDetails.setFont(new Font("Tahoma",Font.PLAIN,31));
        ReservationDetails.setBounds(280,27,359,31);
        add(ReservationDetails);

        pnr_no = new JLabel("PNR_NO");
        pnr_no.setFont(new Font("Tahoma",Font.PLAIN,13));
        pnr_no.setBounds(79,270,83,20);
        add(pnr_no);

        ticket_id = new JLabel("TICKET ID");
        ticket_id.setFont(new Font("Tahoma",Font.PLAIN,13));
        ticket_id.setBounds(172,270,71,20);
        add(ticket_id);

        f_code = new JLabel("FLIGHT_CODE");
        f_code.setFont(new Font("Tahoma",Font.PLAIN,13));
        f_code.setBounds(297,270,103,20);
        add(f_code);

        jny_date = new JLabel("JOURNEY_DATE");
        jny_date.setFont(new Font("Tahoma",Font.PLAIN,13));
        jny_date.setBounds(390,270,94,20);
        add(jny_date);

        jny_time = new JLabel("JOURNEY_TIME");
        jny_time.setFont(new Font("Tahoma",Font.PLAIN,13));
        jny_time.setBounds(494,270,83,20);
        add(jny_time);

        src = new JLabel("SOURCE");
        src.setFont(new Font("Tahoma",Font.PLAIN,13));
        src.setBounds(613,270,94,20);
        add(src);

        dst = new JLabel("DESTINATION");
        dst.setFont(new Font("Tahoma",Font.PLAIN,13));
        dst.setBounds(717,270,94,20);
        add(dst);

        String[] items1 = {"BANGALORE","MUMBAI","CHENNAI","PATNA","DELHI","HYDERABAD"};
        JComboBox comboBox = new JComboBox(items1);
        comboBox.setBounds(150,100,150,27);
        add(comboBox);

        String[] items2 = {"BANGALORE","MUMBAI","CHENNAI","PATNA","DELHI","HYDERABAD"};
        JComboBox comboBox1 = new JComboBox(items2);
        comboBox1.setBounds(509,100,150,27);
        add(comboBox1);

        table = new JTable();
        table.setBounds(38,310,770,130);
        add(table);

        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String src = (String) comboBox.getSelectedItem();
                    String dst = (String) comboBox1.getSelectedItem();

                    conn c = new conn();
                    String str = "select pnr_no,ticket_id,f_code,jny_date,jny_time,src,dst from reservation where src = '"+src+"'and dst = '"+dst+"'";
                    ResultSet rs=c.s.executeQuery(str);

                    if(rs.next())
                    {
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                }else {
                        JOptionPane.showMessageDialog(null,"No flights between Source and Destination");
                    }
            } catch (SQLException e) {}
                }
            });
        setSize(860,600);
        setLocation(400,200);
        setVisible(true);
        }
    }