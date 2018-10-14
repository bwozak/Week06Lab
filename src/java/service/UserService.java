/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author 672762
 */
public class UserService {

    
    /**
     * This method handles User Login
     * @param username
     * @param password
     * @return 
     */
    public User login(String username, String password) {
	
        User adam = new User("adam", "password");
        User betty = new User("betty", "password");
        
        if(username.equals(adam.getUsername()) && password.equals(adam.getPassword())) {
            
            return adam;
        }
        
        else if(username.equals(betty.getUsername()) && password.equals(betty.getPassword())) {
            
            return betty;
        }
        
	return null;
    }
}
