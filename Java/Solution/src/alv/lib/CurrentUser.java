package alv.lib;

public class CurrentUser {
	private static Identity _identity;
	
	private CurrentUser() {}
	
	public static Identity getIdentity() {
		return _identity;
	}

	private static void setIdentity(Usager identity) {
		_identity = new Identity(identity);
	}

	public static boolean Login(String code, String password) {
		if(_identity == null) {
			Usagers list = Usagers.load();
			for(int i = 0; i< list.getItems().size();i++) {
				if(list.getItems().get(i).getCode().equalsIgnoreCase(code) & list.getItems().get(i).getPassword().equalsIgnoreCase(password)) {
					setIdentity(list.getItems().get(i));
				}
			}
		}
		return getIdentity() == null ? false : getIdentity().getCode().equalsIgnoreCase(code);
	}
	
	public static void Logout() {
		_identity = null;
	}
}
