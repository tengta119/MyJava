package LBW24;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class calculatorLBW522
{
    public void showUI()
    {
        CalucOfaction ual = new CalucOfaction();
        JFrame jf = new JFrame();
        jf.setTitle("calculator");
        jf.setSize(210,240);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setLocation(500,300);
        FlowLayout flow = new FlowLayout();
        jf.setLayout(flow);

        JTextField cOUT = new JTextField(30);

        JButton btnAC = new JButton("A");
        JButton btnsp = new JButton("=");
        JButton btnadd = new JButton("+");
        JButton btnleft = new JButton("(");
        JButton btnright = new JButton(")");
        JButton btn0 = new JButton("0");
        JButton btnp = new JButton(".");
        JButton btnCOM = new JButton("%");




        JButton[] btnNUM = new JButton[12];
        String[] labelNUMSTR = {"1","2","3","-","4","5","6","*","7","8","9","\\"};
        for(int i =0;i<btnNUM.length;i++)
        {
            btnNUM[i] = new JButton(labelNUMSTR[i]);
        }

        jf.add(cOUT);
        jf.add(btnAC);
        jf.add(btnsp);
        jf.add(btnCOM);
        jf.add(btnadd);

        cOUT.addActionListener(ual);
        btnAC.addActionListener(ual);
        btnsp.addActionListener(ual);
        btnCOM.addActionListener(ual);
        btnadd.addActionListener(ual);


        for(int i = 0; i< labelNUMSTR.length; i++)
        {

            jf.add(btnNUM[i]);
            btnNUM[i].addActionListener(ual);


        }

        jf.add(btn0);
        jf.add(btnp);//"."
        jf.add(btnleft);
        jf.add(btnright);

        btn0.addActionListener(ual);
        btnp.addActionListener(ual);
        btnleft.addActionListener(ual);
        btnright.addActionListener(ual);



        jf.setVisible(true);
        jf.setResizable(false);




    }

    public static void main(String[] args)
    {
        calculatorLBW522 cal = new calculatorLBW522();
        cal.showUI();
    }


}
