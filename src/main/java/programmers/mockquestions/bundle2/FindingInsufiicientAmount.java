package programmers.mockquestions.bundle2;

public class FindingInsufiicientAmount {
	public long solution(int price, int money, int count) {
		long sum=0;

		for(int i=1; i<=count; i++){
			sum+=price*i;
		}

		return sum-money <0 ? 0 : sum-money;
	}
}
