<#macro masterTemplate title="Welcome to WeBattalia">
    <!DOCTYPE html>
	<html>
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
			<title>WeBattalia | Viewing Match</title>
			<link rel="stylesheet" type="text/css" href="http://www.nickmacholl.com/webattalia/css/style.css">
			<link rel="stylesheet" type="text/css" href="http://www.nickmacholl.com/webattalia/css/cards.css">
		</head>
		
		<header class="banner" style="top:0">
			WeBattalia v${version} ${codename}
		</header>
		
		<body>
			<#nested />
		</body>
		
		<footer class="banner" style="bottom:0">
			Battalia is a reserved trademark of <a href="http://fantasmagoria.bg/" target="_blank">Fantasmagoria Ltd</a>; WeBattalia is a fan creation and is no way affiliated with Fantasmagoria.
		</footer>
    </html>
</#macro>