import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add_Customer extends JFrame {
    JTextField t1, t2, t3, t4, t5, t6, t7;

    public Add_Customer() {
        super("Add Customer");
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778, 486);
        getContentPane().setLayout(null);

        JLabel PassportNo = new JLabel("PASSPORT NO");
        PassportNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
        PassportNo.setBounds(60, 80, 150, 27);
        add(PassportNo);

        t1 = new JTextField();
        t1.setBounds(200, 80, 150, 27);
        add(t1);

        JButton Next = new JButton("SAVE");
        Next.setBounds(200, 420, 150, 30);
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        add(Next);

        JLabel Pnrno = new JLabel("PNR NO");
        Pnrno.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Pnrno.setBounds(60, 120, 150, 27);
        add(Pnrno);

        t2 = new JTextField();
        t2.setBounds(200, 120, 150, 27);
        add(t2);

        JLabel Address = new JLabel("ADDRESS");
        Address.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Address.setBounds(60, 170, 150, 27);
        add(Address);

        t3 = new JTextField();
        t3.setBounds(200, 170, 150, 27);
        add(t3);

        JLabel Nationality = new JLabel("NATIONALITY");
        Nationality.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Nationality.setBounds(60, 220, 150, 27);
        add(Nationality);

        t4 = new JTextField();
        t4.setBounds(200, 220, 150, 27);
        add(t4);

        JLabel Name = new JLabel("NAME");
        Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Name.setBounds(60, 270, 150, 27);
        add(Name);

        t5 = new JTextField();
        t5.setBounds(200, 270, 150, 27);
        add(t5);

        JLabel Gender = new JLabel("GENDER");
        Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Gender.setBounds(60, 320, 150, 27);
        add(Gender);

        JRadioButton Male = new JRadioButton("MALE");
        Male.setBackground(Color.WHITE);
        Male.setBounds(200, 320, 70, 27);
        add(Male);

        JRadioButton Female = new JRadioButton("FEMALE");
        Female.setBackground(Color.WHITE);
        Female.setBounds(280, 320, 70, 27);
        add(Female);

        JLabel Phno = new JLabel("PH NO");
        Phno.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Phno.setBounds(60, 370, 150, 27);
        add(Phno);

        t6 = new JTextField();
        t6.setBounds(200, 370, 150, 27);
        add(t6);

        setVisible(true);

        JLabel AddPassengers = new JLabel("ADD CUSTOMER DETAILS");
        AddPassengers.setForeground(Color.BLUE);
        AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
        AddPassengers.setBounds(420, 24, 442, 35);
        add(AddPassengers);

        JLabel Flightcode = new JLabel("FLIGHT CODE");
        Flightcode.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Flightcode.setBounds(60, 30, 150, 27);
        add(Flightcode);

        t7 = new JTextField();
        t7.setBounds(200, 30, 150, 27);
        add(t7);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/emp.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(450, 80, 280, 410);
        add(image);

        Next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                    String passport_No = t1.getText();
                    String pnr_no = t2.getText();
                    String address = t3.getText();
                    String nationality = t4.getText();
                    String name = t5.getText();
                    String fl_code = t7.getText();

                    String gender = null;
                    String ph_no = t6.getText();

                    if (Male.isSelected()) {
                        gender = "Male";
                    } else if (Female.isSelected()) {
                        gender = "Female";
                    }
                    try {
                        conn c = new conn();
                        String str = "INSERT INTO passenger values ('" + pnr_no + "' , '" + address + "','" + nationality + "','" + name + "','" + gender + "','" + ph_no + "','" + passport_No + "','" + fl_code + "')";

                        c.s.executeUpdate(str);
                        JOptionPane.showMessageDialog(null, "Customer Added");
                        setVisible(false);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

        setSize(900,600);
        setVisible(true);
        setLocation(400,200);
        }

        public static void main (String[] args)
        {
            new Add_Customer();
        }
}