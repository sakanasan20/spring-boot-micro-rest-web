package tw.niq.app.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import tw.niq.app.model.request.UpdateUserDetailsRequestModel;
import tw.niq.app.model.request.UserDetailsRequestModel;
import tw.niq.app.model.response.UserRest;

@Service
public class UserServiceImpl implements UserService {
	
	Map<String, UserRest> users = new HashMap<>();
	
	@Override
	public UserRest getUser(String userId) {
		return users.get(userId);
	}

	@Override
	public UserRest createUser(@Valid UserDetailsRequestModel userDetails) {
		
		UserRest returnValue = new UserRest();
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		returnValue.setEmail(userDetails.getEmail());
		
		String userId = UUID.randomUUID().toString();
		returnValue.setUserId(userId);
		
		users.put(userId, returnValue);
		
		return returnValue;
	}

	@Override
	public UserRest updateUser(String userId, @Valid UpdateUserDetailsRequestModel userDetails) {
		
		UserRest storedUserDetails = users.get(userId);
		
		if (storedUserDetails != null) {

			storedUserDetails.setFirstName(userDetails.getFirstName());
			storedUserDetails.setLastName(userDetails.getLastName());
			
			users.put(userId, storedUserDetails);
		} 
		
		return storedUserDetails;
	}

	@Override
	public void deleteUser(String userId) {
		users.remove(userId);
	}

}
