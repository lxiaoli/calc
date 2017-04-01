package com.lxl.clac;


import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class CalcFrame extends JFrame{
	
	private JLabel labelResult;
	
	String[] title = {"","","Del","C","7","8","9","/","4","5","6","%","1","2","3","*","0","+","-","="};
	
	/**
	 * 按钮
	 */
	private JButton[] buttons = new JButton[title.length];
	
	public CalcFrame() {
		initui();
		setVisible(true);
	}

	private void initui() {
		setTitle("计算器");
		setSize(320, 480);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//添加结果标签
		labelResult = new JLabel("0.0");
		labelResult.setBorder(new EmptyBorder(20, 10, 20, 10));
		labelResult.setHorizontalAlignment(SwingConstants.RIGHT);
		labelResult.setFont(new Font("微软雅体",Font.PLAIN,32));
		add(labelResult,BorderLayout.NORTH);
		
		//添加按钮
		//按钮面板
		JPanel buttonPanel = new JPanel();
		//设置布局
		buttonPanel.setLayout(new GridLayout(5, 4,5,5));
		//按钮面板添加到窗口中间
		add(buttonPanel,BorderLayout.CENTER);
		
		for (int i = 0;i<title.length;i++) {
			if(title[i].length()==0){
				//不显示内容的标签
				buttonPanel.add(new JPanel());
			}else{
				//按钮
				buttons[i] = new JButton(title[i]);
				buttonPanel.add(buttons[i]);
			}
			
		}
	}

}
