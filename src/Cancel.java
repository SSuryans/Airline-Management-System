import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Cancel extends JFrame {
    private JTextField t0,t1,t2,t3,t4;

    public static void main(String[]args)
    {
        new Cancel();
    }

    public Cancel(){
        initialize();
    }

    private void initialize(){
        setTitle("CANCELLATION");;
        getContentPane().setBackground(Color.WHITE);
        setBounds(100,100,801,472);
        setLayout(null);

        JLabel Cancellation = new JLabel("CANCELLATION");
        Cancellation.setFont(new Font("Tahoma",Font.PLAIN,31));
        Cancellation.setBounds(185,24,259,38);
        add(Cancellation);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/cancel.png"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel NewLabel = new JLabel(i3);
        NewLabel.setBounds(470,100,250,250);
        add(NewLabel);

        JLabel pnrno = new JLabel("PNR NO");
        pnrno.setFont(new Font("Tahoma",Font.PLAIN,17));
        pnrno.setBounds(60,100,132,26);
        add(pnrno);

        JLabel Cancellationno = new JLabel("CANCELLATION NO");
        Cancellationno.setFont(new Font("Tahoma",Font.PLAIN,17));
        Cancellationno.setBounds(60,150,150,27);
        add(Cancellationno);

        JLabel CancellationDate = new JLabel("CANCELLATION DATE");
        CancellationDate.setFont(new Font("Tahoma",Font.PLAIN,17));
        CancellationDate.setBounds(60,200,180,27);
        add(CancellationDate);

        JLabel Ticketid = new JLabel("TICKET ID");
        Ticketid.setFont(new Font("Tahoma",Font.PLAIN,17));
        Ticketid.setBounds(60,250,150,27);
        add(Ticketid);

        JLabel Flightcode = new JLabel("FLIGHT CODE");
        Flightcode.setFont(new Font("Tahoma",Font.PLAIN,17));
        Flightcode.setBounds(60,300,150,27);
        add(Flightcode);

        JButton Cancel = new JButton("CANCEL");
        Cancel.setFont(new Font("Tahoma",Font.PLAIN,14));
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.setBounds(250,350,150,30);
        add(Cancel);

        t0 = new JTextField();
        t0.setBounds(250,100,150,27);
        add(t0);

        t1 = new JTextField();
        t1.setBounds(250,150,150,27);
        add(t1);

        t2 = new JTextField();
        t2.setBounds(250,200,150,27);
        add(t2);

        t3 = new JTextField();
        t3.setBounds(250,250,150,27);
        add(t3);

        t4 = new JTextField();
        t4.setBounds(250,300,150,27);
        add(t4);

        Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String pnr_no = t0.getText();
                String cancellation_no = t1.getText();
                String cancellation_date = t2.getText();
                String ticket_id = t3.getText();
                String flight_code = t4.getText();

                try{
                    conn c = new conn();
                    c.s.executeUpdate("DELETE FROM reservation where pnr_no='"+pnr_no+"'");
                    JOptionPane.showMessageDialog(null,"Ticket Cancelled");
                    setVisible(false);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        setSize(860,500);
        setVisible(true);
        setLocation(400,200);
    }
}