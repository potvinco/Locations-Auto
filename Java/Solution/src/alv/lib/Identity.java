package alv.lib;

public class Identity {

	private Usager _usager;
	private UsagerRoles _usagerRoles;
	private Roles _roles;

	public Identity(Usager usager) {
		setUsager(usager);
	}
	
	public String getCode() {
		return getUsager() == null ? "" : getUsager().getCode();
	}
	
	private Usager getUsager() {
		return _usager;
	}

	private void setUsager(Usager _usager) {
		this._usager = _usager;
		setUsagerRoles(UsagerRoles.load(getUsager() == null ? 0 : getUsager().getId()));
	}
	
	private UsagerRoles getUsagerRoles() {
		return _usagerRoles;
	}

	private void setUsagerRoles(UsagerRoles _usagerRoles) {
		this._usagerRoles = _usagerRoles;
	}

	private Roles getRoles() {
		_roles = _roles == null ? Roles.load() : _roles;
		return _roles;
	}

	public boolean isInRole(String key) {
		boolean returnValue = false;

		for(int j = 0;j< getRoles().getItems().size(); j++  ) {
			if(getRoles().getItems().get(j).getKey().equalsIgnoreCase(key)) {
				Role role = getRoles().getItems().get(j);
			
				if(getUsagerRoles() != null){
					for(int i = 0;i< getUsagerRoles().getItems().size(); i++  ) {
						if(getUsagerRoles().getItems().get(i).getRoleId() == role.getId()) {
							return true;
						}
					}
				}
			}
		}
		
		return returnValue;
	}
}
