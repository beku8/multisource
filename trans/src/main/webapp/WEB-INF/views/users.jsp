<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Users page</title>
</head>
<body>
<h1>
	Look at these users!  
</h1>
	<ul>
		<c:forEach items="${users }" var="user">
			<li>${user.username }
				<ul>
					<c:forEach items="${user.itemses }" var="item">
						<li>${item.name }</li>
					</c:forEach>
				</ul>
			</li>
		</c:forEach>
	</ul>

</body>
</html>
