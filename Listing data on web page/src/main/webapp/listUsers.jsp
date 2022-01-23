<%@include file="include/header.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="studyeasy.org.entity.Users"%>
<div class="container mtb">
	<div class="row">
		<div class="col-lg-6">
			<strong>Listing Users</strong>
			<hr />
			<table>
				<thead>
					<th>User ID</th>
					<th>User Name</th>
					<th>Email</th>
				</thead>
				<%
				String updateURL, deleteURL;
				List<Users> listUsers = (List<Users>) request.getAttribute("listUsers");
				out.print(listUsers.size());
				for (int i = 0; i < listUsers.size(); i++) {
					out.print("<tr>");
					out.print("<td>" + listUsers.get(i).getUsersId() + "</td>");
					out.print("<td>" + listUsers.get(i).getUserName() + "</td>");
					out.print("<td>" + listUsers.get(i).getEmail() + "</td>");
					updateURL = request.getContextPath() + "/Operation?page=updateUser" + "&userId=" + listUsers.get(i).getUsersId()
					+ "&userName=" + listUsers.get(i).getUserName() + "&email=" + listUsers.get(i).getEmail();
					out.print("<td><a href=" + updateURL + ">Update</a></td>");
					deleteURL = request.getContextPath() + "/Operation?page=deleteUser" + "&userId=" + listUsers.get(i).getUsersId();
				%>
				<td><a href="<%=deleteURL%>"
					onclick="if(!confirm('Are you sure to delete the user?')) return false">Delete</a>
				</td>
				</tr>
				<%
				}
				%>
			</table>
		</div>
	</div>
</div>
<%@include file="include/footer.jsp"%>