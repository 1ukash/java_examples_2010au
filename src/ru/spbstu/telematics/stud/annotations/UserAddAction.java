package ru.spbstu.telematics.stud.annotations;

public class UserAddAction extends Action {

	@Override
	@PermissionRequired(Permission.MANAGER)
	void invoke() {
		boolean isAdmin = true; //false
		if (!checkPermission(isAdmin)) {
			throw new RuntimeException("illegal access");
		}

		//add user
	}

}
