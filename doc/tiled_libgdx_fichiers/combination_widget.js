

function dsqComboTab(tab) {
	document.getElementById('dsq-combo-people').style.display = "none";
	document.getElementById('dsq-combo-popular').style.display = "none";
	document.getElementById('dsq-combo-recent').style.display = "none";
	document.getElementById('dsq-combo-tab-people').className = "dsq-combo-tab";
	document.getElementById('dsq-combo-tab-popular').className = "dsq-combo-tab";
	document.getElementById('dsq-combo-tab-recent').className = "dsq-combo-tab";

	document.getElementById('dsq-combo-' + tab).style.display = "block";
	document.getElementById('dsq-combo-tab-' + tab).className = "dsq-combo-tab dsq-active";
}

document.write(' \
<style type="text/css" media="screen">\
	 #dsq-combo-widget ul,\
	 #dsq-combo-widget li,\
	 #dsq-combo-widget ol,\
	 #dsq-combo-widget div,\
	 #dsq-combo-widget p,\
	 #dsq-combo-widget a,\
	 #dsq-combo-widget cite,\
	 #dsq-combo-widget img {\
	 border: 0;\
	 padding: 0;\
	 margin: 0;\
	 float: none;\
	 text-indent: 0;\
	 background: none;\
	 }\
	 #dsq-combo-widget ul,\
	 #dsq-combo-widget li,\
	 #dsq-combo-widget ol {\
	 list-style-type: none;\
	 list-style-image: none;\
	 background: none;\
	 display: block;\
	 }\
	 #dsq-combo-widget #dsq-combo-content ul,\
	 #dsq-combo-widget #dsq-combo-content li,\
	 #dsq-combo-widget #dsq-combo-content ol,\
	 #dsq-combo-widget #dsq-combo-content div,\
	 #dsq-combo-widget #dsq-combo-content p,\
	 #dsq-combo-widget #dsq-combo-content a,\
	 #dsq-combo-widget #dsq-combo-content cite,\
	 #dsq-combo-widget #dsq-combo-content img {\
	 border: 0;\
	 padding: 0;\
	 margin: 0;\
	 float: none;\
	 text-indent: 0;\
	 background: none;\
	 }\
	 #dsq-combo-widget #dsq-combo-content ul,\
	 #dsq-combo-widget #dsq-combo-content li,\
	 #dsq-combo-widget #dsq-combo-content ol {\
	 list-style-type: none;\
	 list-style-image: none;\
	 background: none;\
	 display: block;\
	 }\
	 .dsq-clearfix:after {\
	 content:".";\
	 display: block;\
	 height: 0;\
	 clear: both;\
	 visibility: hidden;\
	 }\
	 /* end reset */\
	 #dsq-combo-widget { ;\
	 text-align: left;\
	 }\
	 #dsq-combo-widget #dsq-combo-tabs {\
	 float: left;\
	 }\
	 #dsq-combo-widget #dsq-combo-content {\
	 position: static;\
	 }\
	 #dsq-combo-widget #dsq-combo-content h3 {\
	 float: none;\
	 text-indent: 0;\
	 background: none;\
	 padding: 0;\
	 border: 0;\
	 margin: 0 0 10px 0;\
	 font-size: 16px;\
	 }\
	 #dsq-combo-widget #dsq-combo-tabs li {\
	 display: inline;\
	 float: left;\
	 margin-right: 2px;\
	 padding: 0px 5px;\
	 text-transform: uppercase;\
	 }\
	 #dsq-combo-widget #dsq-combo-tabs li a {\
	 text-decoration: none;\
	 font-weight: bold;\
	 font-size: 10px;\
	 }\
	 #dsq-combo-widget #dsq-combo-content .dsq-combo-box {\
	 margin: 0 0 20px;\
	 padding: 12px;\
	 clear: both;\
	 }\
	 #dsq-combo-widget #dsq-combo-content .dsq-combo-box li {\
	 padding-bottom: 10px;\
	 margin-bottom: 10px;\
	 overflow: hidden;\
	 word-wrap: break-word;\
	 }\
	 #dsq-combo-widget #dsq-combo-content .dsq-combo-avatar {\
	 float: left;\
	 height: 48px;\
	 width: 48px;\
	 margin-right: 15px;\
	 }\
	 #dsq-combo-widget #dsq-combo-content .dsq-combo-box cite {\
	 font-weight: bold;\
	 font-size: 14px;\
	 }\
	 span.dsq-widget-clout {\
	 background-color:#FF7300;\
	 color:#FFFFFF;\
	 padding:0pt 2px;\
	 }\
	 #dsq-combo-logo { text-align: right; }\
	 /* Blue */\
	 #dsq-combo-widget.blue #dsq-combo-tabs li.dsq-active { background: #E1F3FC; }\
	 #dsq-combo-widget.blue #dsq-combo-content .dsq-combo-box { background: #E1F3FC; }\
	 #dsq-combo-widget.blue #dsq-combo-tabs li { background: #B5E2FD; }\
	 #dsq-combo-widget.blue #dsq-combo-content .dsq-combo-box li { border-bottom: 1px dotted #B5E2FD; }\
	 /* Grey */\
	 #dsq-combo-widget.grey #dsq-combo-tabs li.dsq-active { background: #f0f0f0; }\
	 #dsq-combo-widget.grey #dsq-combo-content .dsq-combo-box { background: #f0f0f0; }\
	 #dsq-combo-widget.grey #dsq-combo-tabs li { background: #ccc; }\
	 #dsq-combo-widget.grey #dsq-combo-content .dsq-combo-box li { border-bottom: 1px dotted #ccc; }\
	 /* Green */\
	 #dsq-combo-widget.green #dsq-combo-tabs li.dsq-active { background: #f4ffea; }\
	 #dsq-combo-widget.green #dsq-combo-content .dsq-combo-box { background: #f4ffea; }\
	 #dsq-combo-widget.green #dsq-combo-tabs li { background: #d7edce; }\
	 #dsq-combo-widget.green #dsq-combo-content .dsq-combo-box li { border-bottom: 1px dotted #d7edce; }\
	 /* Red */\
	 #dsq-combo-widget.red #dsq-combo-tabs li.dsq-active { background: #fad8d8; }\
	 #dsq-combo-widget.red #dsq-combo-content .dsq-combo-box { background: #fad8d8; }\
	 #dsq-combo-widget.red #dsq-combo-tabs li { background: #fdb5b5; }\
	 #dsq-combo-widget.red #dsq-combo-content .dsq-combo-box li { border-bottom: 1px dotted #fdb5b5; }\
	 /* Orange */\
	 #dsq-combo-widget.orange #dsq-combo-tabs li.dsq-active { background: #fae6d8; }\
	 #dsq-combo-widget.orange #dsq-combo-content .dsq-combo-box { background: #fae6d8; }\
	 #dsq-combo-widget.orange #dsq-combo-tabs li { background: #fddfb5; }\
	 #dsq-combo-widget.orange #dsq-combo-content .dsq-combo-box li { border-bottom: 1px dotted #fddfb5; }\
	 </style>\
	 <div id="dsq-combo-widget" class="grey">\
	 <ul id="dsq-combo-tabs">\
	 <li id="dsq-combo-tab-people" ><a href="#" onclick="dsqComboTab(\'people\'); return false">People</a></li>\
	 <li id="dsq-combo-tab-recent" ><a href="#" onclick="dsqComboTab(\'recent\'); return false">Recent</a></li>\
	 <li id="dsq-combo-tab-popular" class="dsq-active"><a href="#" onclick="dsqComboTab(\'popular\'); return false">Popular</a></li>\
	 </ul>\
	 <div id="dsq-combo-content">\
	 <div id="dsq-combo-people" class="dsq-combo-box" style="display:none">\
	 <h3>Top Commenters</h3>\
	 <ul>\
	 <li class="dsq-clearfix">\
	 <a href="https://disqus.com/by/gamefromscratch/">\
	 <img class="dsq-combo-avatar" src="//a.disquscdn.com/1525220586/images/noavatar92.png">\
	 </a>\
	 <cite><a href="https://disqus.com/by/gamefromscratch/">gamefromscratch</a></cite>\
	 <div><span class="dsq-widget-clout" title="Clout: Reputation on Disqus"></span>&nbsp;&middot;&nbsp;688 posts</div>\
	 </li>\
	 <li class="dsq-clearfix">\
	 <a href="https://disqus.com/by/eXpl0it3r/">\
	 <img class="dsq-combo-avatar" src="https://c.disquscdn.com/uploads/users/2610/2818/avatar92.jpg?1354465239">\
	 </a>\
	 <cite><a href="https://disqus.com/by/eXpl0it3r/">Lukas Dürrenberger</a></cite>\
	 <div><span class="dsq-widget-clout" title="Clout: Reputation on Disqus"></span>&nbsp;&middot;&nbsp;17 posts</div>\
	 </li>\
	 <li class="dsq-clearfix">\
	 <a href="https://disqus.com/by/disqus_whBvfVE82R/">\
	 <img class="dsq-combo-avatar" src="//a.disquscdn.com/1525220586/images/noavatar92.png">\
	 </a>\
	 <cite><a href="https://disqus.com/by/disqus_whBvfVE82R/">Babar</a></cite>\
	 <div><span class="dsq-widget-clout" title="Clout: Reputation on Disqus"></span>&nbsp;&middot;&nbsp;17 posts</div>\
	 </li>\
	 <li class="dsq-clearfix">\
	 <a href="https://disqus.com/by/disqus_h3lE3suKKl/">\
	 <img class="dsq-combo-avatar" src="https://c.disquscdn.com/uploads/users/4835/7567/avatar92.jpg?1415730331">\
	 </a>\
	 <cite><a href="https://disqus.com/by/disqus_h3lE3suKKl/">Romualdo</a></cite>\
	 <div><span class="dsq-widget-clout" title="Clout: Reputation on Disqus"></span>&nbsp;&middot;&nbsp;13 posts</div>\
	 </li>\
	 </ul>\
	 <div id="dsq-combo-logo"><a href="https://disqus.com"><img src="//a.disquscdn.com/1525220586/images/embed/widget-logo.png"></a></div>\
	 </div>\
	 <div id="dsq-combo-recent" class="dsq-combo-box" style="display:none">\
	 <h3>Recent Comments</h3>\
	 <ul>\
	 <li class="dsq-clearfix">\
	 <a href="https://disqus.com/by/Quast/"><img class="dsq-combo-avatar" src="https://c.disquscdn.com/uploads/users/354/8220/avatar92.jpg?1525412978"></a>\
	 <a class="dsq-widget-user" href="https://disqus.com/by/Quast/">Quast</a>\
	 <span class="dsq-widget-comment"><p>Great tutorial. Post more please.<br>Thank you.</p></span>\
	 <p class="dsq-widget-meta"><a href="http://www.gamefromscratch.com/post.aspx?id=c4032328-12df-4744-ab82-a754c7d3c7ab">Introduction To Unity’s Shader Graph</a>&nbsp;&middot;&nbsp;<a href="http://www.gamefromscratch.com/post.aspx?id=c4032328-12df-4744-ab82-a754c7d3c7ab#comment-3885258803">1 day ago</a></p>\
	 </li>\
	 <li class="dsq-clearfix">\
	 <img class="dsq-combo-avatar" src="//a.disquscdn.com/1525220586/images/noavatar92.png">\
	 Andy\
	 <span class="dsq-widget-comment"><p>Something I\'ve been having trouble with is getting click events to properly register for instantiated scenes within my main scene. I have a simple scene with a sprite and an Area2D (Let\'s call this...</p></span>\
	 <p class="dsq-widget-meta"><a href="http://www.gamefromscratch.com/page.aspx?id=01381001-6956-46eb-9717-34f61d99f474">Godot 3 Tutorial–Keyboard, Mouse and Joystick Input</a>&nbsp;&middot;&nbsp;<a href="http://www.gamefromscratch.com/page.aspx?id=01381001-6956-46eb-9717-34f61d99f474#comment-3882467732">3 days ago</a></p>\
	 </li>\
	 <li class="dsq-clearfix">\
	 <a href="https://disqus.com/by/ViRiX_Dreamcore/"><img class="dsq-combo-avatar" src="https://c.disquscdn.com/uploads/users/4233/6069/avatar92.jpg?1525242603"></a>\
	 <a class="dsq-widget-user" href="https://disqus.com/by/ViRiX_Dreamcore/">ViRiX_Dreamcore</a>\
	 <span class="dsq-widget-comment"><p>I\'m using SourceTree to clone it and it says it\'s unable to access the repository. Is it still there?</p></span>\
	 <p class="dsq-widget-meta"><a href="http://www.gamefromscratch.com/post.aspx?id=3e7c8dae-cd44-4891-837a-7e21b6c4c8bb">Great Collection of Blender Cycles Materials (And How To Use It)</a>&nbsp;&middot;&nbsp;<a href="http://www.gamefromscratch.com/post.aspx?id=3e7c8dae-cd44-4891-837a-7e21b6c4c8bb#comment-3881998297">3 days ago</a></p>\
	 </li>\
	 <li class="dsq-clearfix">\
	 <a href="https://disqus.com/by/blackpointfarkaskornel/"><img class="dsq-combo-avatar" src="//a.disquscdn.com/1525220586/images/noavatar92.png"></a>\
	 <a class="dsq-widget-user" href="https://disqus.com/by/blackpointfarkaskornel/">blackpoint //Farkas Kornel//</a>\
	 <span class="dsq-widget-comment"><p>Can somebody please help me? <a href="https://uploads.disquscdn.com/images/a7a9f4d5129c7e8512c3cd04095027192a77d698c9e7d954a26a0068edbf5071.png" rel="nofollow noopener" title="https://uploads.disquscdn.com/images/a7a9f4d5129c7e8512c3cd04095027192a77d698c9e7d954a26a0068edbf5071.png">https://uploads.disquscdn.c...</a></p></span>\
	 <p class="dsq-widget-meta"><a href="http://www.gamefromscratch.com/post.aspx?id=0d2d308f-4a57-4545-95d3-f8853b5e58d4">Installing XNA Tools Like XACT without Visual Studio 2010</a>&nbsp;&middot;&nbsp;<a href="http://www.gamefromscratch.com/post.aspx?id=0d2d308f-4a57-4545-95d3-f8853b5e58d4#comment-3874328217">1 week ago</a></p>\
	 </li>\
	 </ul>\
	 <div id="dsq-combo-logo"><a href="https://disqus.com"><img src="//a.disquscdn.com/1525220586/images/embed/widget-logo.png"></a></div>\
	 </div>\
	 <div id="dsq-combo-popular" class="dsq-combo-box" >\
	 <h3>Most Discussed</h3>\
	 <ul>\
	 <li class="dsq-clearfix">\
	 <a class="dsq-widget-thread" href="http://www.gamefromscratch.com/page.aspx?id=01381001-6956-46eb-9717-34f61d99f474">Godot 3 Tutorial–Keyboard, Mouse and Joystick Input</a>\
	 <p class="dsq-widget-meta"> comment &middot; 3 days ago</p>\
	 </li>\
	 <li class="dsq-clearfix">\
	 <a class="dsq-widget-thread" href="http://www.gamefromscratch.com/post.aspx?id=2a39c9a3-ee22-467e-bff5-245fb87498f8">Blender Game Engine Removed From Blender 2.8</a>\
	 <p class="dsq-widget-meta"> comment &middot; 1 week ago</p>\
	 </li>\
	 <li class="dsq-clearfix">\
	 <a class="dsq-widget-thread" href="http://www.gamefromscratch.com/post.aspx?id=b08f4e5a-42fe-4e19-8086-b69f6c8e85d9">Dust3D–A New Open Source 3D Modeller</a>\
	 <p class="dsq-widget-meta"> comment &middot; 2 weeks ago</p>\
	 </li>\
	 <li class="dsq-clearfix">\
	 <a class="dsq-widget-thread" href="http://www.gamefromscratch.com/post.aspx?id=0d779a35-b2d6-4071-b968-5d7c908a3b73">Phaser 3.4.0 Released</a>\
	 <p class="dsq-widget-meta"> comment &middot; 3 weeks ago</p>\
	 </li>\
	 </ul>\
	 <div id="dsq-combo-logo"><a href="https://disqus.com"><img src="//a.disquscdn.com/1525220586/images/embed/widget-logo.png"></a></div>\
	 </div>\
	 </div>\
	 </div>\
');
