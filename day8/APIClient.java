package week3.day8;

public class APIClient {
	public void sendRequest(boolean b) {
		System.out.println("boolean b " + b);
	}

	public void sendRequest(String endpoint, String requestBody, boolean requestStatus) {
		System.out.println("endpoint " + endpoint);
		System.out.println("requestBody " + requestBody);
		System.out.println("requestStatus " + requestStatus);

	}

	public static void main(String[] args) {
		APIClient apiobj = new APIClient();
		
		apiobj.sendRequest(true);

		apiobj.sendRequest("test1","test2",false);

	}
}