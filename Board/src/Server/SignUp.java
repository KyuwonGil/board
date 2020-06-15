package Server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Users;
import DTO.UsersEntity;

@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SignUp() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Users users = new Users();
		UsersEntity user = new UsersEntity();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		String pnum = request.getParameter("pnum");
		String email = request.getParameter("email");
		
		user.setId(id);
		user.setPw(pw);
		user.setName(name);
		user.setBirthday(birthday);
		user.setGender(gender);
		user.setPnum(pnum);
		user.setEmail(email);
		
		if(users.signUp(user))
			response.sendRedirect("/");
	}
}
