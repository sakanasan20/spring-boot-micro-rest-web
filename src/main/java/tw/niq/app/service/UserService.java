package tw.niq.app.service;

import javax.validation.Valid;

import tw.niq.app.model.request.UpdateUserDetailsRequestModel;
import tw.niq.app.model.request.UserDetailsRequestModel;
import tw.niq.app.model.response.UserRest;

public interface UserService {

	UserRest getUser(String userId);
	
	UserRest createUser(@Valid UserDetailsRequestModel userDetails);

	UserRest updateUser(String userId, @Valid UpdateUserDetailsRequestModel userDetails);

	void deleteUser(String userId);

}
