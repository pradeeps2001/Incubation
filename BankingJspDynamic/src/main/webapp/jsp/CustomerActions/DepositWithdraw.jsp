<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Deposit/Withdraw</title>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/jsp/css/frameProps.css" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Inter&display=swap">
</head>
<body>
	<div>
		<h4>${heading}</h4>
		<section>
			<div class="container mx-auto my-auto mt-4">
				<div class="card border-0 shadow rounded-3" id="smallCard">
					<div class="card-body">
						<form action="<%=request.getContextPath()%>/myServlet"
							target="content" method="post">
							<div id="mode">
								<label id="mediumLabel">Type : </label> <input type="text"
									id="underline" name="transaction"
									value="<c:out value="${transaction}"/>" readonly />
							</div>
							<div>
								<label for="accountDrop" id="mediumLabel">Account : </label> 
								<select name="accountDrop" id="bigDropdown" required>
								
									<c:choose>
										<c:when test="${accountDrop == null }">
											<option value="" selected disabled hidden="hidden">Choose here</option>
										</c:when>
										<c:otherwise>
											<option value="" selected disabled hidden="hidden">${accountDrop}</option>
										</c:otherwise>
									</c:choose>
									
									<c:forEach var="accountSet" items="${accountSet}">
										<option value="${accountSet}">${accountSet}</option>
									</c:forEach>
								</select>
							</div>
							<div>
								<label id="mediumLabel">Amount : </label><input type="number"
									id="underline" name="amount" min="1" placeholder="Enter Amount"
									required>
								<div class="text-centre mt-3">
									<button class="btn btn-outline-success btn-sm" id="mdLabelBtn"
										type="submit" value="Proceed" name="data">${transaction}</button>
									<button class="btn btn-outline-primary btn-sm ms-2"
										type="reset">Reset</button>
								</div>
							</div>
							<br>
							<div>
								<span class="text-success">${success}</span> <span
									class="text-danger">${error}</span>
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>
</html>