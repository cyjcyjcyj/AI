package com.ai.vo;

import java.util.ArrayList;

public class RuleVO {
	                     //����Ϊ�ַ�������
	public int id;
	public ArrayList<String> conditions ;//= new ArrayList<String>();          //�������������б�����
	public String result;
	public int can_end;

	public String conditionstr;
	public RuleVO(){
		conditions = new ArrayList<String>();
		can_end=0;
	}
//	public Rule(ArrayList<String> cause, String result) {
//		this.result = result;
//		this.cause = cause;
//
//	}
}
