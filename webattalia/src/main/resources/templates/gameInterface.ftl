<#import "master.ftl" as layout />

<@layout.masterTemplate title="WeBattalia Game">
			<h2>Here is your starting hand.</h2>
			<div id=playerArea>
				<ul id=playerHand>
					<!-- Base Hand -->
					<li class="${card1faction}" title="${card1title}" draggable="true"><img src="http://www.nickmacholl.com/webattalia/svg/${card1type}.svg" onerror="this.onerror=null; this.src='http://www.nickmacholl.com/webattalia/png/${card1type}.png">
					<li class="${card2faction}" title="${card2title}" draggable="true"><img src="http://www.nickmacholl.com/webattalia/svg/${card2type}.svg" onerror="this.onerror=null; this.src='http://www.nickmacholl.com/webattalia/png/${card2type}.png">
					<li class="${card3faction}" title="${card3title}" draggable="true"><img src="http://www.nickmacholl.com/webattalia/svg/${card3type}.svg" onerror="this.onerror=null; this.src='http://www.nickmacholl.com/webattalia/png/${card3type}.png">
					<li class="${card4faction}" title="${card4title}" draggable="true"><img src="http://www.nickmacholl.com/webattalia/svg/${card4type}.svg" onerror="this.onerror=null; this.src='http://www.nickmacholl.com/webattalia/png/${card4type}.png">
					<li class="${card5faction}" title="${card5title}" draggable="true"><img src="http://www.nickmacholl.com/webattalia/svg/${card5type}.svg" onerror="this.onerror=null; this.src='http://www.nickmacholl.com/webattalia/png/${card5type}.png">
					<li class="${card6faction}" title="${card6title}" draggable="true"><img src="http://www.nickmacholl.com/webattalia/svg/${card6type}.svg" onerror="this.onerror=null; this.src='http://www.nickmacholl.com/webattalia/png/${card6type}.png">
				</ul>
			</div>
</@layout.masterTemplate>