<#macro masterTemplate title="Welcome to WeBattalia">
    <!DOCTYPE html>
	<html>
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
			<title>WeBattalia | Viewing Match</title>
			<link rel="stylesheet" type="text/css" href="http://www.nickmacholl.com/webattalia/css/style.css">
			<link rel="stylesheet" type="text/css" href="http://www.nickmacholl.com/webattalia/css/cards.css">
			<script src="http://www.nickmacholl.com/webattalia/scripts/webattalia.js"></script>
			<script src="http://www.nickmacholl.com/webattalia/scripts/util.js"></script>
			<script src="http://www.nickmacholl.com/webattalia/scripts/market.js"></script>
			<script src="http://www.nickmacholl.com/webattalia/scripts/audio.js"></script>
		</head>
		
		<header class="banner" style="top:0">
			WeBattalia v${version} ${codename}
		</header>
		
		<body>
			<#nested />
		</body>
		
		<footer class="banner" style="bottom:0">
			WeBattalia is fan made and not affiliated with <a href="http://fantasmagoria.bg/" target="_blank">Fantasmagoria Ltd</a>.
		</footer>
    </html>
</#macro>