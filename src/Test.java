import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Test extends JFrame {
	private static final long serialVersionUID = 1L;

	//
	private JLabel jUserLabel;
	private JTextField jTvField;
	private JLabel jPassLabel;
	private JTextField jMvField;
	private JButton jComputeButton;
	private JTextArea jRstArea;
	private JPanel jPanel1;
	private JTextField jMField;
	private JTextField jNField;
	
	
	int iTvalue,iMvalue,jm,jn;

	//

	public Test() {

		init();

		this.setSize(1000, 600);
		this.setTitle("程序");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		try {
			enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		} catch (Exception e) {
			e.printStackTrace();
		}

		compute144();
	}

	public void init() {
		jUserLabel = new JLabel("K值:");
		jTvField = new JTextField("425");
		jTvField.setColumns(5);
		jPassLabel = new JLabel("M值:");
		jMvField = new JTextField("25");
		jMvField.setColumns(5);
		jMField = new JTextField("200");
		jMField.setColumns(5);
		jNField = new JTextField("20");
		jNField.setColumns(5);
		jComputeButton = new JButton("计算");
		jRstArea = new JTextArea();
		JScrollPane js=new JScrollPane(jRstArea);
		//分别设置水平和垂直滚动条自动出现
		js.setHorizontalScrollBarPolicy(
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		js.setVerticalScrollBarPolicy(
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		 

		jPanel1 = new JPanel();
		jPanel1.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));


		jPanel1.add(jUserLabel);
		jPanel1.add(jTvField);
		jPanel1.add(jPassLabel);
		jPanel1.add(jMvField);
		jPanel1.add(jMField);
		jPanel1.add(jNField);
		jPanel1.add(jComputeButton);

		this.add(jPanel1, BorderLayout.NORTH);
		this.add(js,BorderLayout.CENTER);

		jComputeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String tString = jTvField.getText();
					iTvalue = Integer.parseInt(tString);
					String mString = jMvField.getText();
					iMvalue = Integer.parseInt(mString);
					mString = jMField.getText();
					jm = Integer.parseInt(mString);
					mString = jNField.getText();
					jn = Integer.parseInt(mString);
					jRstArea.setText("");
					computeKvalue();

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "请输入数字！", "信息",
							JOptionPane.INFORMATION_MESSAGE);
					e.printStackTrace();
				}
			}
		});

	}
	
	List<Databuf> dataList = new ArrayList<Databuf>();

	public void computeKvalue(){
		int i= 0;
//		dataList.remove(0);
		for(Databuf tmpDatabuf : dataList){
			StringBuffer strmsg = new StringBuffer();
			strmsg.append(tmpDatabuf.strhexString);
			strmsg.append("\t");
			String strweight = tmpDatabuf.strweightString;
			int ik = iTvalue - iMvalue;
			int n = 0;
			int n1 = 0,n2 = 0,n3 = 0,n4 = 0;
			for(int j = 0; j < 4; j++){
				int x = Integer.parseInt(strweight.substring(j, j+1));
				n= x * 25;
				if(j == 0) n1 = n;
				if(j == 1) n2 = n;
				if(j == 2) n3 = n;
				if(j == 3) n4 = n;
			}
			ik = (ik - n1 - n2 - n3 - n4)/2;

			strmsg.append(Integer.toHexString(ik));
			strmsg.append("\t");
			strmsg.append(Integer.toHexString(iMvalue/5));
			strmsg.append("\t");
			strmsg.append(Integer.toHexString(n1));
			strmsg.append("\t");
			strmsg.append(Integer.toHexString(iMvalue/5));
			strmsg.append("\t");
			strmsg.append(Integer.toHexString(n2));
			strmsg.append("\t");
			strmsg.append(Integer.toHexString(iMvalue/5));
			strmsg.append("\t");
			strmsg.append(Integer.toHexString(n3));
			strmsg.append("\t");
			strmsg.append(Integer.toHexString(iMvalue/5));
			strmsg.append("\t");
			strmsg.append(Integer.toHexString(n4));
			strmsg.append("\t");
			strmsg.append(Integer.toHexString(jm + i*jn));
			strmsg.append("\n");
			jRstArea.append(strmsg.toString().toUpperCase());
			
			i++;
			if(i == 145){
				return;
			}
		}
	}
	
	public void compute144(){
		for(int i = 0; i <= 255; i++){
			
			String zbinaryString ="00000000";
			String binaryString = Integer.toBinaryString(i);
			binaryString = zbinaryString.substring(0, 8-binaryString.length())+binaryString;
			System.out.println("binaryString = " + binaryString);
			
			zbinaryString ="00";
			String hexString = Integer.toHexString(i);
			hexString = zbinaryString.substring(0, 2-hexString.length())+hexString;
			hexString = hexString.toUpperCase();
			System.out.println("hexString = " + hexString);
			
			String wString = "";
			int iwvalue = 0;
			for(int j = 0; j < 4; j++){
				String str1 = binaryString.substring(2*j, 2*j+2);
				if(str1.equals("00")){
					wString = wString + 1;
					iwvalue += 1;
				}else if(str1.equals("01")){
					wString = wString + 2;
					iwvalue += 2;
				}else if(str1.equals("10")){
					wString = wString + 3;
					iwvalue += 3;
				}else{
					wString = wString + 4;
					iwvalue += 4;
				}
			}
			System.out.println(wString);
			System.out.println(iwvalue);
			
			Databuf tmpDatabuf = new Databuf(i,iwvalue,binaryString,hexString,wString);
			dataList.add(tmpDatabuf);

		}
		
		Collections.sort(dataList, new Comparator<Object>() {

			public int compare(Object lhs, Object rhs) {
				
				if (((Databuf)lhs).wvalue > ((Databuf)rhs).wvalue) {
					return 1;
				} else if(((Databuf)lhs).wvalue < ((Databuf)rhs).wvalue) {
					return -1;
				}
				return 0;
			}

		});

		for(Databuf tmpDatabuf : dataList){
			System.out.println(tmpDatabuf.strhexString + " " + tmpDatabuf.strbinString + " " + tmpDatabuf.strweightString + " " + tmpDatabuf.wvalue);
		}

	}
	
	
	
	public static void main(String[] args){
		new Test();
	}
}


class Databuf{
	public int value;
	public String strbinString;
	public String strhexString;
	public String strweightString;
	public int wvalue;
	
	public Databuf(int a,int b,String c,String d,String e){
		value = a;
		wvalue = b;
		strbinString = new String();strbinString = c;
		strhexString = new String();strhexString = d;
		strweightString = new String();strweightString = e;
	}
}