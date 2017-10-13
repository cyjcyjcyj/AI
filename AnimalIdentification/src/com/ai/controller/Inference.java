package com.ai.controller;

import java.util.*;

import com.ai.dao.RulesDAO;
import com.ai.vo.RuleVO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class Inference {
	
	private ArrayList<String> InputList = new ArrayList<String>();

	private ArrayList<RuleVO> rulesList;//������ж������������淶����

	//private ArrayList<String> factbase;//��ʵ�⣬��������������
	private ArrayList<String> resultbase;//����⣬��ŵ�ǰ������Ϊ���۵Ķ��Ｏ

	public Inference(ArrayList<String> InputList) {
		this.InputList = InputList;
		rulesList = new ArrayList<RuleVO>();
		rulesList = new RulesDAO().getRules();
		resultbase = new ArrayList<String>();
		resultbase = new RulesDAO().getResultBase();
	}
/*�÷���ͨ���Ƚ��û�����͹����б�����������,�ж��û������Ƿ������ĳ���������������,
 * ������,�ͱȽ��������������,��ͣ��ѭ��,ֱ�����һ������.
 * ����,�ж���������Ľ����Ƿ�Ϊ���ս���,����,�򷵻ؽ���!����,�жϸ�������Ľ����Ƿ�Ӧ�������û������б���.
 * */
	public String MatchAndFindResult() {
		/*�ж��û������Ƿ�Ϊ��,�Լ��Ƿ�ì��*/
		//if (InputList != null && isContradict(InputList)) {
		boolean getnewinput = true;
		while(getnewinput){
			if (InputList != null) {
				getnewinput = false;
				for (int i = 0; i< rulesList.size(); i++) {
					//������е�˳λ����
					RuleVO rule = rulesList.get(i);
					//����ۺ����ݿ��п���ƥ�䵽�ù���
					if (InputList.containsAll(rule.conditions)){
						
						String result = rule.result;
						//��������ս�
						if (resultbase.contains(result)) {
							return result;
						}else if(!InputList.contains(result)){
								InputList.add(result);
								rulesList.remove(rule);
								getnewinput = true;
						}
					}
				}
			}
		}
		return null;
	}

	public String MatchAndFindResult1() {
		/*�ж��û������Ƿ�Ϊ��,�Լ��Ƿ�ì��*/
		//if (InputList != null && isContradict(InputList)) {
		boolean getnewinput = true;
		String returnstr="";
		List<Map> list = new ArrayList<Map>();
		int resultnum=0;
		while(getnewinput){
			if (InputList != null) {
				getnewinput = false;
				for (int i = 0; i< rulesList.size(); i++) {
					//������е�˳λ����
					RuleVO rule = rulesList.get(i);
					//����ۺ����ݿ��п���ƥ�䵽�ù���
					if (InputList.containsAll(rule.conditions)){
						
						 JSONObject jo = new JSONObject();

					        // ���湹������map��һ��list��һ��Employee����
						 Map<String, String> map = new HashMap<String, String>();
					     map.put("conditions", rule.conditionstr);
					     map.put("result", rule.result);
					        
					        list.add(map);
						
						String result = rule.result;
						//��������ս�
						if (resultbase.contains(result)) {
							JSONArray jay = JSONArray.fromObject(list);
							returnstr = jay.toString();
							rulesList.remove(rule);
							resultnum++;
							System.out.println(rulesList.size()+"dada");
							i--;
							//return jay.toString();
						}else if(!InputList.contains(result)){
								InputList.add(result);
								rulesList.remove(rule);
								System.out.println(rulesList.size()+"kaka");
								i--;
								getnewinput = true;
						}
						
					}
				}
			}
		}
		System.out.println(resultnum+"eeee");
		if(resultnum>1)
			returnstr="2";
		else if(resultnum==0)
			returnstr="0";
		
		return returnstr;
	}
	

}
