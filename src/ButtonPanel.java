/*
 資管三A 劉昌平
 103403519
 */

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;


public class ButtonPanel extends JPanel {
	   private GridLayout gridlayout;
	   private JLabel label1, label2;
	   private JRadioButton big, mid, small;
	   private ButtonGroup radiogroup;
	   private JCheckBox full;
	   private JButton front, back, clear;
	   private JComboBox formatselection;
	   private static final String format[] = {"筆刷直線", "橢圓形", "矩形", "圓角矩形"};
	   
	   public ButtonPanel(){  
		   setBackground(Color.CYAN);
		   gridlayout = new GridLayout(10,1);
		   setLayout(gridlayout);
		   
		   label1 = new JLabel("繪圖工具");
		   add(label1);
		   
		   formatselection = new JComboBox(format);
		   formatselection.setMaximumRowCount(5);
		   formatselection.addItemListener(new ComboBoxHandler());
		   add(formatselection);
		   
		   label2 = new JLabel("筆刷大小");
		   add(label2);
		   
		   small = new JRadioButton("小",false);
		   mid = new JRadioButton("中", true);
		   big = new JRadioButton("大", false);
		   add(small);
		   add(mid);
		   add(big);
		   radiogroup = new ButtonGroup();
		   radiogroup.add(small);
		   radiogroup.add(mid);
		   radiogroup.add(big);
		   small.addItemListener(new RadioButtonHandler("small"));
		   mid.addItemListener(new RadioButtonHandler("mid"));
		   big.addItemListener(new RadioButtonHandler("big"));
		   
		   full = new JCheckBox("填滿");
		   add(full);
		   full.addItemListener(new CheckBoxHandler());
		   
		   front = new JButton("前景色");
		   back = new JButton("後景色");
		   clear = new JButton("清除畫面");
		   add(front);
		   add(back);
		   add(clear);
		   ButtonHandler handler = new ButtonHandler();
		   front.addActionListener(handler);
		   back.addActionListener(handler);
		   clear.addActionListener(handler);
	   }
	   
	   public class ComboBoxHandler implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			  if(e.getStateChange() == ItemEvent.SELECTED)
				   JOptionPane.showMessageDialog( null, String.format("您選擇了:%s", e.getItem() ));
		}   
	   }
	   
	   public class RadioButtonHandler implements ItemListener{
			private String message;
			public RadioButtonHandler(String s){
				if (s == "small")
					message = "小";
				else if (s == "mid")
					message = "中";
				else
					message = "大";
			}
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1)
					JOptionPane.showMessageDialog(null,"您選取了「" + message + "」筆刷");
			}
		}
	   
	   public class ButtonHandler implements ActionListener{
			public void actionPerformed(ActionEvent e) {
		        JOptionPane.showMessageDialog( null, String.format("您選擇了:%s", e.getActionCommand() ) );
			}
		}
	   
	   public class CheckBoxHandler implements ItemListener{
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1)
					JOptionPane.showMessageDialog(null, "已填滿");
				else 
					JOptionPane.showMessageDialog(null, "已取消填滿");		
			}	
		}
}