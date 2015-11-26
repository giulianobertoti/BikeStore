import org.json.JSONException;

public class TestRest {
	
	public static void main(String[] args) throws JSONException {
		final Rest rest = new Rest();
		rest.addEstoqueRest();
		rest.getBike();
	}	
}
