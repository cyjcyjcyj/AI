
import java.util.ArrayList;

import com.ai.controller.Inference;
import com.ai.dao.FeatureDAO;
import com.ai.dao.RulesDAO;

public class Test {
	@org.junit.Test
	public void test() {
		String aString = "�кڷ�";
		String bString = "��ۻ";
		String cString = "��ɫ�ǰ�ɫ";
		String dString = "�к�ɫ����";
		
		ArrayList<String> inputlist = new ArrayList<String>();
		inputlist.add(aString);
		inputlist.add(bString);
		inputlist.add(cString);
		inputlist.add(dString);
//		
//		Inference inference = new Inference(inputlist);
//		String result = inference.MatchAndFindResult();
//		
//		System.out.println("++"+result);
		
		//new RulesDAO().addRule(inputlist, "������","1");
		
		System.out.println(new FeatureDAO().getFeatureList().size());
	}
	
	

}
