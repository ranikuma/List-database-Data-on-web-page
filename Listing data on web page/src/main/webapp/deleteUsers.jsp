<%@include file="include/header.jsp"%>
<div class="container mtb">
	<div class="row">
		<div class="col-lg-6">
			<form action=${pageContext.request.contextPath}/Operation
				method="post">
				UserId: <input type="text" name="userName" value="${param.userName}"
					required="required" /><br /> Email: <input type="number"
					name="userId" value="${param.email}" required="required" /><br /> <input
					type="hidden" name="userId" value="${param.userId}"><br />
				<input type="hidden" name="form" value="updateUserOperation"><br />
				<input type="submit" name="Delete User" value="Delete User">
			</form>

		</div>
	</div>
</div>
<%@include file="include/footer.jsp"%>