import com.example.*
class BootStrap {

    def init = { servletContext ->
		
		if(!User.count()){
			/*The default password is 'password'*/
			def password = 'password'
			def user = new User(username : 'raman', password:password,enabled:true,
				accountExpired : false , accountLocked : false ,passwordExpired : false).save(flush: true, insert: true)
				
			def role = new Role(authority : 'ROLE_USER').save(flush: true, insert: true)
			def role1 = new Role(authority : 'ADMIN_ROLE').save(flush: true, insert: true)
			/*create the first user role map*/
			UserRole.create user , role , true
			//UserRole.create user , role1 , true
		}
    }
    def destroy = {
    }
}
