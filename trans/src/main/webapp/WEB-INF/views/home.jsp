<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

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
