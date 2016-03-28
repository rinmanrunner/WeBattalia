<#import "master.ftl" as layout />

<@layout.masterTemplate title="WeBattalia Game">
			<div id="leaderboard">
				<ul>
					<!-- First Player -->
					<li>
						<div id="emberianPlayer">
							<img src="http://avatarfiles.alphacoders.com/488/4887.gif">
							<div class="playerScore">2</div>
							<b>TheCowboy</b>
						</div>
					</li>
					<!-- Second Player -->
					<li>
						<div id="cloudbornPlayer">
							<img src="http://www.progarchives.com/forum/uploads/18319/Mr_Blonde_BandW_300.jpeg">
							<div class="playerScore">2</div>
							<b>Mr Blonde</b> (You)
						</div>
					</li>
					<!-- Third Player -->
					<li>
						<div id="islanderPlayer">
							<img src="http://avatarfiles.alphacoders.com/265/26511.gif">
							<div class="playerScore">3</div>
							<b>LuigiSux</b>
						</div>
					</li>
					<!-- Fourth Player -->
					<li>
						<div id="barfolkPlayer">
							<img src="http://www.webdesignerforum.co.uk/uploads/profile/photo-1407.jpg">
							<div class="playerScore">6</div>
							<b>P1X3L</b>
						</div>
					</li>
				</ul>
			</div>
			<div id="playArea">
				<div id="board">
					<ul>
						<!-- First Row -->
						<li>
						</li><li>
						</li><li>
						</li><li>
						</li><li>
						</li><li>
						</li><li></li><br>
						<!-- Second Row -->
						</li><li>
						</li><li>
						</li><li>
						</li><li>
						</li><li>
						</li><li>
						</li><li></li><br>
						<!-- Third Row -->
						</li><li>
						</li><li>
						</li><li>
						</li><li>
						</li><li>
						</li><li>
						</li><li></li><br>
						<!-- Fourth Row -->
						</li><li>
						</li><li>
						</li><li>
						</li><li>
						</li><li>
						</li><li>
						</li><li></li><br>
						<!-- Fifth Row -->
						</li><li>
						</li><li>
						</li><li>
						</li><li>
						</li><li>
						</li><li>
						</li><li></li><br>
						<!-- Sixth Row -->
						</li><li>
						</li><li>
						</li><li>
						</li><li>
						</li><li>
						</li><li>
						</li><li></li><br>
						<!-- Seventh Row -->
						</li><li>
						</li><li>
						</li><li>
						</li><li>
						</li><li>
						</li><li>
						</li><li></li><br>
					</ul>
				</div>
				<div id="market"></div>
				<div id="build"></div>
				<div id="storage"></div>
				<!-- The Action Line -->
				<div id="actionLine" ondrop="drop(event)" ondragover="allowDrop(event)">
					<ul id="actionList">
					</ul>
				</div>
			</div>
			<div id="playerArea" ondrop="drop(event)" ondragover="allowDrop(event)">
				<!-- Player's Hand -->
				<div id="playerHand">
					<ul id="playerHandList">
						<!-- Base Hand -->
						<li id="c1" class="${card1faction}" cardtype="${card1type}" title="${card1title}" ondragstart="drag(event)" draggable="true"><img src="http://www.nickmacholl.com/webattalia/svg/${card1type}.svg" onerror="this.onerror=null; this.src='http://www.nickmacholl.com/webattalia/png/${card1type}.png">
						<li id="c2" class="${card2faction}" cardtype="${card2type}" title="${card2title}" ondragstart="drag(event)" draggable="true"><img src="http://www.nickmacholl.com/webattalia/svg/${card2type}.svg" onerror="this.onerror=null; this.src='http://www.nickmacholl.com/webattalia/png/${card2type}.png">
						<li id="c3" class="${card3faction}" cardtype="${card3type}" title="${card3title}" ondragstart="drag(event)" draggable="true"><img src="http://www.nickmacholl.com/webattalia/svg/${card3type}.svg" onerror="this.onerror=null; this.src='http://www.nickmacholl.com/webattalia/png/${card3type}.png">
						<li id="c4" class="${card4faction}" cardtype="${card4type}" title="${card4title}" ondragstart="drag(event)" draggable="true"><img src="http://www.nickmacholl.com/webattalia/svg/${card4type}.svg" onerror="this.onerror=null; this.src='http://www.nickmacholl.com/webattalia/png/${card4type}.png">
						<li id="c5" class="${card5faction}" cardtype="${card5type}" title="${card5title}" ondragstart="drag(event)" draggable="true"><img src="http://www.nickmacholl.com/webattalia/svg/${card5type}.svg" onerror="this.onerror=null; this.src='http://www.nickmacholl.com/webattalia/png/${card5type}.png">
						<li id="c6" class="${card6faction}" cardtype="${card6type}" title="${card6title}" ondragstart="drag(event)" draggable="true"><img src="http://www.nickmacholl.com/webattalia/svg/${card6type}.svg" onerror="this.onerror=null; this.src='http://www.nickmacholl.com/webattalia/png/${card6type}.png">
						<!-- Cohort -->
						<!-- Empty Hand Placeholder -->
						<li id="emptyHand">Your hand is empty.</li>
					</ul>
				</div>
				<!-- Player's Shelter (discard) -->
				<div id="playerShelter" title="Shelter"></div>
				<!-- Player's Nation (draw) -->
				<div id="playerNation" title="Nation"></div>
			</div>
</@layout.masterTemplate>