package DAO;

import java.util.Queue;
import DTO.UsersEntity;

public class Users {
	
	DataAcessObject dao = null;
	
	public Users() {
		dao = new DataAcessObject();
	}
	
	public UsersEntity findAccount(String id) {
		String sql = "SELECT * FROM USERS WHERE ID = ?";
		Queue<UsersEntity> attribute = dao.select(sql, new String[]{id});
		UsersEntity user = attribute.poll();
		
		return user;
	}
	
	public Queue<UsersEntity> findAllAccount(String id){
		String sql = "SELECT * FROM USERS";
		Queue<UsersEntity> attribute = dao.select(sql, null);
		
		return attribute;
	}
	
	public boolean signIn(String id, String pw) {
		String sql = "SELECT * FROM USERS WHERE ID = ? AND PW = ?";
		Queue<UsersEntity> signInAccount = dao.select(sql, new String[] {id, pw});
		boolean isSignIn = !signInAccount.isEmpty();
		signInAccount.clear();
		return isSignIn;
	}
	
	public boolean signUp(UsersEntity user) {
		String sql = "INSERT INTO USERS VALUES(?,?,?,?,?,?,?)";
		return dao.insert(sql, new String[] {
			user.getId(), 
			user.getPw(),
			user.getName(),
			user.getBirthday(),
			user.getGender(),
			user.getPnum(),
			user.getEmail()
		});
	}
	
	public boolean modifyPassword(UsersEntity user) {
		String sql = "UPDATE USERS SET PW = ? WHERE ID = ?";
		return dao.update(sql, new String[] {user.getPw(), user.getId()}) != 0;
	}
	
	public boolean modifyName(UsersEntity user) {
		String sql = "UPDATE USERS SET NAME = ? WHERE ID = ?";
		return dao.update(sql, new String[] {user.getName(), user.getId()}) != 0;
	}
	
	public boolean withdrawal(String id) {
		String sql = "DELETE FROM USERS WHERE ID = ?";
		return dao.delete(sql, new String[] {id}) != 0;
	}
}
