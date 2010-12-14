package ru.spbstu.telematics.stud.annotations;

public abstract class Action {
	
	abstract void invoke();
	
	boolean checkPermission(boolean isAdmin) {
		
		Class<? extends Action> clazz = this.getClass();
		PermissionRequired perm = clazz.getAnnotation(PermissionRequired.class);
		
		if (perm != null) {
			return perm.value() == Permission.USER || (isAdmin && perm.value() == Permission.MANAGER);
		}
		
		return false;
	}
}
