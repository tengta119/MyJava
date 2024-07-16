package LBW24;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Date;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class CalucOfaction implements ActionListener
{
    ArrayList<String> strcmputeArr = new ArrayList<>();
    int[] num = new int[100];

    public void actionPerformed(ActionEvent e)
    {
        strcmputeArr.add(e.getActionCommand());
        System.out.println(strcmputeArr);
        if(e.getActionCommand().equals("A"))
        {
            strcmputeArr.clear();
            System.out.println("已清除，请重新计算");
        }
        else if (e.getActionCommand().equals("="))
        {

            String[] strcmputeStr = strcmputeArr.toArray(new String[0]);
            int result = cmpute(strcmputeStr);
            System.out.println(result);

        }

    }

    int BaseCompute(int num1,int num2,char a)
    {
        switch (a)
        {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            case '%':
                return num1 % num2;
            default:
                return 0;
        }


    }

    int cmpute(String[] str)
    {
        int[] num = new int[100]; //存放的数字
        int[] temp = new int[100];//中间结果
        int numi = 0;
        int numii = 0;
        int tempi = 0;
        int tempii = 0;
        int i = 0;//i代表字符串的位置


            char c0;
            if(str[i].equals("("))
            {
                i++;//移动到“（”后的位置
                num[numi++] = Integer.parseInt(str[i++]);//将“（”后的数字传递给num

                char c1 = str[i].charAt(0);
                i++;//移动到符合后的位置
                num[numi++] = Integer.parseInt(str[i++]);
                i++;//跳到“）”后的位置
                temp[tempi++] = BaseCompute(num[numi - 2], num[numi - 1],c1);
                numi -=2;

            }

            c0 = str[i].charAt(0);
            i++;

            if(str[i].equals("("))
            {
                i++;//移动到“（”后的位置
                num[numi++] = Integer.parseInt(str[i++]);//将“（”后的数字传递给num

                char c1 = str[i].charAt(0);
                i++;//移动到符合后的位置
                num[numi++] = Integer.parseInt(str[i++]);//将数字传递给num后，后移
                i++;//跳到“）”后的位置
                temp[tempi++] = BaseCompute(num[numi - 2], num[numi - 1],c1);
                numi -=2;
            }
                temp[tempi++] = BaseCompute(temp[tempi-3],temp[tempi-2],c0);





        return temp[tempi-1];
    }


}
