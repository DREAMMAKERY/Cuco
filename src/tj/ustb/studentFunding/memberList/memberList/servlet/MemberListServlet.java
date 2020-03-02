package tj.ustb.studentFunding.memberList.memberList.servlet;



import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tj.ustb.studentFunding.memberList.memberList.domain.MemberList;
import tj.ustb.studentFunding.memberList.memberList.service.MemberListService;
import tj.ustb.studentFunding.user.domain.Headmaster;
import tj.ustb.studentFunding.user.service.StudentException;
import cn.itcast.servlet.BaseServlet;

public class MemberListServlet extends BaseServlet {
	private MemberListService mls = new MemberListService();
	
	public String findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, StudentException{
		List<MemberList> list = mls.findAll();
		if(list == null) throw new StudentException("暂无显示信息");

		request.setAttribute("MemberList",list);
	
		return "f:/DepartmentReview/user/MemberList.jsp";
	}
	
}
