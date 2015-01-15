
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.32*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html>
<head>
<meta name="viewport" content="width=device-width" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Büchern - Webtech</title>
<link rel="stylesheet" type="text/css" href="""),_display_(/*10.46*/routes/*10.52*/.Assets.at("stylesheets/style.css")),format.raw/*10.87*/(""">
<meta name="description"
	content="Büchern - Das Portal um gebrauchte Bücher zu Vorlesungen zu kaufen und zu verkaufen">
<meta name="author" content="Gruppe 6">
<meta name="keywords" content="WebtechWS14, Webtech, Büchern, Büchern Konstanz, Büchern HTWG, HTWG Konstanz, HTWG, Konstanz">
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>	

<script>
$(function() """),format.raw/*18.14*/("""{"""),format.raw/*18.15*/("""
  """),format.raw/*19.3*/("""var menuVisible = false;
  $('#menuBtn').click(function() """),format.raw/*20.34*/("""{"""),format.raw/*20.35*/("""
    """),format.raw/*21.5*/("""if (menuVisible) """),format.raw/*21.22*/("""{"""),format.raw/*21.23*/("""
      """),format.raw/*22.7*/("""$('#myMenu').css("""),format.raw/*22.24*/("""{"""),format.raw/*22.25*/("""'display':'none'"""),format.raw/*22.41*/("""}"""),format.raw/*22.42*/(""");
      menuVisible = false;
      return;
    """),format.raw/*25.5*/("""}"""),format.raw/*25.6*/("""
    """),format.raw/*26.5*/("""$('#myMenu').css("""),format.raw/*26.22*/("""{"""),format.raw/*26.23*/("""'display':'block'"""),format.raw/*26.40*/("""}"""),format.raw/*26.41*/(""");
    menuVisible = true;
  """),format.raw/*28.3*/("""}"""),format.raw/*28.4*/(""");
  $('#myMenu').click(function() """),format.raw/*29.33*/("""{"""),format.raw/*29.34*/("""
    """),format.raw/*30.5*/("""$(this).css("""),format.raw/*30.17*/("""{"""),format.raw/*30.18*/("""'display':'none'"""),format.raw/*30.34*/("""}"""),format.raw/*30.35*/(""");
    menuVisible = false;
  """),format.raw/*32.3*/("""}"""),format.raw/*32.4*/(""");
"""),format.raw/*33.1*/("""}"""),format.raw/*33.2*/(""");

$(function() """),format.raw/*35.14*/("""{"""),format.raw/*35.15*/("""
    """),format.raw/*36.5*/("""var WS = window['MozWebSocket'] ? MozWebSocket : WebSocket
    var dateSocket = new WS(""""),_display_(/*37.31*/routes/*37.37*/.Application.statusWs().webSocketURL(request)),format.raw/*37.82*/("""")

    var receiveEvent = function(event) """),format.raw/*39.40*/("""{"""),format.raw/*39.41*/("""
        """),format.raw/*40.9*/("""$("#output").html("Status: "+event.data);
    """),format.raw/*41.5*/("""}"""),format.raw/*41.6*/("""

    """),format.raw/*43.5*/("""dateSocket.onmessage = receiveEvent
"""),format.raw/*44.1*/("""}"""),format.raw/*44.2*/(""");

</script>
</head>
<body>
	<section id="homepage">
		<div id="homepagecontent">
			<header>
				<div id="logo">
					<a href="""),_display_(/*53.15*/routes/*53.21*/.Application.index()),format.raw/*53.41*/("""><img id="logobild" src="""),_display_(/*53.66*/routes/*53.72*/.Assets.at("images/logo.jpg")),format.raw/*53.101*/(""" """),format.raw/*53.102*/("""name="büchernlogo" /></a>
				</div>

				<div id="headerrechts">
					<div class="loginform">
						<div id="login">
							<form action="logIn" method="Post">
								<input name="benutzername" type="text" placeholder="benutzername"
									size="30" maxlength="30"> <br> <input
									name="passwort" type="password" placeholder="passwort" size="30"
									maxlength="40">
	
								<input type="submit" value="Login" id="subButton"/>
							</form>	
					</div>

					</div>
				</div>

			<div class="clear"></div>
			<div id="slider">
				<div id="bilderslider">
					<img id="bildinslider" src="""),_display_(/*75.34*/routes/*75.40*/.Assets.at("images/slider2.jpg")),format.raw/*75.72*/(""" """),format.raw/*75.73*/("""/>
				</div>
			</div>
			
			</header>
			
			<nav id="navigation">		
					<div id="respnav">
						<div id="wrapper">
							<div id="menuBtn"><img src="""),_display_(/*84.36*/routes/*84.42*/.Assets.at("images/navi.png")),format.raw/*84.71*/("""/></div>
							<nav id="myMenu">
								<ul>
									<li><p><a class="respnavlink" href="""),_display_(/*87.46*/routes/*87.52*/.Application.index()),format.raw/*87.72*/(""">Startseite</a></li>
									<li><p><a class="respnavlink" href="""),_display_(/*88.46*/routes/*88.52*/.Application.einkaufen()),format.raw/*88.76*/(""">Einkaufen</a></p></li>
									<li><p><a class="respnavlink" href="""),_display_(/*89.46*/routes/*89.52*/.Application.verkaufen()),format.raw/*89.76*/(""">Verkaufen</a></p></li>
									<!--  <li><p><a class="respnavlink" href="""),_display_(/*90.52*/routes/*90.58*/.Application.index()),format.raw/*90.78*/(""">Bestseller</a></p></li>-->
									<li><p><a class="respnavlink" href="""),_display_(/*91.46*/routes/*91.52*/.Application.profile()),format.raw/*91.74*/(""">Profil</a></p></li>
								</ul>
							</nav>
						</div>	
					</div>
					<div class="navlinks">
						<div class="linkbox link">
							<div class="linkboxlink"><a href="""),_display_(/*98.42*/routes/*98.48*/.Application.index()),format.raw/*98.68*/(""">Startseite</a></div>
						</div> 
						<div class="linkbox link">
							<div class="linkboxlink"><a href="""),_display_(/*101.42*/routes/*101.48*/.Application.einkaufen()),format.raw/*101.72*/(""">Einkaufen</a></div>
						</div> 
						<div class="linkbox link">
							<div class="linkboxlink"><a href="""),_display_(/*104.42*/routes/*104.48*/.Application.verkaufen()),format.raw/*104.72*/(""">Verkaufen</a></div>
						</div> 
						<!--<div class="linkbox link">
							<div class="linkboxlink"><a href="""),_display_(/*107.42*/routes/*107.48*/.Application.index()),format.raw/*107.68*/(""">Bestseller</a></div>
						</div> -->
						<div class="linkbox link">
							<div class="linkboxlink"><a href="""),_display_(/*110.42*/routes/*110.48*/.Application.profile()),format.raw/*110.70*/(""">Profil</a></div>
						</div> 
					</div>
			</nav>
			<article>
			"""),_display_(/*115.5*/content),format.raw/*115.12*/("""
			"""),format.raw/*116.4*/("""<div style="clear:both"></div>
			</article>
			<div class="buttonspacer"></div>
			<aside id="footer_container">
				<div id="footer">
					<span class="footerlink"><a href=mailto:bakopf@htwg-konstanz.de>Support Anfrage per E-Mail</a>  <span id="output">  </span></span>
				</div>
			</aside>

		</div>
	</section>
</body>
</html>
"""))}
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Jan 15 18:56:03 CET 2015
                  SOURCE: C:/Users/Fabian/Documents/WebTech/buechern/app/views/main.scala.html
                  HASH: 7c4ba003c5eaffc0b496dc8f283c9af7e95d0e79
                  MATRIX: 727->1|845->31|875->35|1140->273|1155->279|1211->314|1643->718|1672->719|1703->723|1790->782|1819->783|1852->789|1897->806|1926->807|1961->815|2006->832|2035->833|2079->849|2108->850|2186->901|2214->902|2247->908|2292->925|2321->926|2366->943|2395->944|2453->975|2481->976|2545->1012|2574->1013|2607->1019|2647->1031|2676->1032|2720->1048|2749->1049|2808->1081|2836->1082|2867->1086|2895->1087|2942->1106|2971->1107|3004->1113|3121->1203|3136->1209|3202->1254|3275->1299|3304->1300|3341->1310|3415->1357|3443->1358|3478->1366|3542->1403|3570->1404|3735->1542|3750->1548|3791->1568|3843->1593|3858->1599|3909->1628|3939->1629|4595->2258|4610->2264|4663->2296|4692->2297|4884->2462|4899->2468|4949->2497|5071->2592|5086->2598|5127->2618|5221->2685|5236->2691|5281->2715|5378->2785|5393->2791|5438->2815|5541->2891|5556->2897|5597->2917|5698->2991|5713->2997|5756->3019|5967->3203|5982->3209|6023->3229|6164->3342|6180->3348|6226->3372|6366->3484|6382->3490|6428->3514|6572->3630|6588->3636|6630->3656|6774->3772|6790->3778|6834->3800|6937->3876|6966->3883|6999->3888
                  LINES: 26->1|29->1|31->3|38->10|38->10|38->10|46->18|46->18|47->19|48->20|48->20|49->21|49->21|49->21|50->22|50->22|50->22|50->22|50->22|53->25|53->25|54->26|54->26|54->26|54->26|54->26|56->28|56->28|57->29|57->29|58->30|58->30|58->30|58->30|58->30|60->32|60->32|61->33|61->33|63->35|63->35|64->36|65->37|65->37|65->37|67->39|67->39|68->40|69->41|69->41|71->43|72->44|72->44|81->53|81->53|81->53|81->53|81->53|81->53|81->53|103->75|103->75|103->75|103->75|112->84|112->84|112->84|115->87|115->87|115->87|116->88|116->88|116->88|117->89|117->89|117->89|118->90|118->90|118->90|119->91|119->91|119->91|126->98|126->98|126->98|129->101|129->101|129->101|132->104|132->104|132->104|135->107|135->107|135->107|138->110|138->110|138->110|143->115|143->115|144->116
                  -- GENERATED --
              */
          