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
	 * ��ť
	 */
	private JButton[] buttons = new JButton[title.length];
	
	public CalcFrame() {
		initui();
		setVisible(true);
	}

	private void initui() {
		setTitle("������");
		setSize(320, 480);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//��ӽ����ǩ
		labelResult = new JLabel("0.0");
		labelResult.setBorder(new EmptyBorder(20, 10, 20, 10));
		labelResult.setHorizontalAlignment(SwingConstants.RIGHT);
		labelResult.setFont(new Font("΢������",Font.PLAIN,32));
		add(labelResult,BorderLayout.NORTH);
		
		//��Ӱ�ť
		//��ť���
		JPanel buttonPanel = new JPanel();
		//���ò���
		buttonPanel.setLayout(new GridLayout(5, 4,5,5));
		//��ť�����ӵ������м�
		add(buttonPanel,BorderLayout.CENTER);
		
		for (int i = 0;i<title.length;i++) {
			if(title[i].length()==0){
				//����ʾ���ݵı�ǩ
				buttonPanel.add(new JPanel());
			}else{
				//��ť
				buttons[i] = new JButton(title[i]);
				buttonPanel.add(buttons[i]);
			}
			
		}
	}

}
