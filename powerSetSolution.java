package labs;

public class powerSetSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] SetS = {1,2,3,4};
		String [] powerset = powerSet(SetS);
		System.out.print("{");
		for(int i = 0; i < powerset.length; i++){
			System.out.print(" {" + powerset[i] + "}," );
		}

		System.out.print("}");
	}
	private static String [] powerSet(int[] setS) {

		if(setS.length == 0){
			String []empty = new String[1];
			empty [0] = "";
			return empty;
		}
		int [] temp = new int [setS.length-1];
		int x = setS[setS.length-1];

		for(int i = 0 ; i < temp.length; i++){
			temp[i] = setS[i];
		}
		String [] tempPwrSet = powerSet(temp);

		String []  newPart = new String[tempPwrSet.length];

		for(int i = 0 ; i < tempPwrSet.length; i++){
			String e = tempPwrSet[i];
			newPart[i] = e + " "  + x;
		}

		String[] finalPowerset = new String[tempPwrSet.length*2];
		for(int i = 0; i < tempPwrSet.length; i++){

			finalPowerset[i] = tempPwrSet[i];

			//finalPowerset[i] = tempPwrSet[i];
		}

		for(int i = 0; i < newPart.length; i++){
			finalPowerset[i+newPart.length] = newPart[i];
		}


		//int[] e = new int [setS]

		return finalPowerset;




	}




}
