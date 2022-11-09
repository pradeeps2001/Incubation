<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Frame</title>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/jsp/css/menu.css" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Inter&display=swap">
</head>
<body>
	<div>
		<h6>Welcome ${userName}</h6>
	<form action="<%=request.getContextPath() %>/myServlet" target="content">
		<button type="submit" id="menu-start" class="btn btn-dark btn-sm" value="Home" name="data" >
		<span id="icons" class="material-symbols-outlined">home</span>Home
		</button>
		<button type="submit" id="menu" class="btn btn-secondary btn-sm" value="Account Info" name="data">
			<span id="icons" class="material-symbols-outlined">account_balance_wallet</span>Accounts
		</button>
		<button type="submit" id="menu" class="btn btn-secondary btn-sm mt-2" value="Transaction History" name="data">
		<span id="icons" class="material-symbols-outlined">history</span>Transaction History
		</button>
		<div class="right-menu">
					<div>
						<button id="menuicon" class="btn btn-dark btn-sm mt-2" id="menu" type="button" value="drop">
							<span id="icons" class="material-symbols-outlined">paid</span><p id="transaction">Transaction</p>
						</button>
					</div>
					<div class="dropdown-menu">
					<div class="text-centre">
						<button class="btn btn-dark btn-sm" id="dropdownMenu" type="submit" value="Deposit Cash" name="data">
							<span id="icons" class="material-symbols-outlined">savings</span>Deposit
						</button>
					</div>
					<div class="text-centre mt-1">
						<button class="btn btn-dark btn-sm" id="dropdownMenu" type="submit" value="Withdraw Cash" name="data">
							<span id="icons" class="material-symbols-outlined">payments</span>Withdraw
						</button>
					</div>
					<div class="text-centre mt-1">
						<button class="btn btn-dark btn-sm" id="dropdownMenu" type="submit" value="Transfer Cash" name="data">
							<span id="icons" class="material-symbols-outlined">currency_exchange</span>Transfer
						</button>
					</div>
			</div>
		</div>
	</form>
	</div>
</body>
</html>