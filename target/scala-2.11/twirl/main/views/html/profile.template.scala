
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
object profile extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[List[Book],User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(BookList :List[Book], ActualUser :User):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.42*/(""" """),_display_(/*1.44*/main("Profile")/*1.59*/{_display_(Seq[Any](format.raw/*1.60*/("""

"""),format.raw/*3.1*/("""<div id="content">
	<div id="leftSidebar">
		<div id="userProfile">
			<div id="userDataShown">
				<img class="userImage" src="""),_display_(/*7.33*/routes/*7.39*/.Assets.at( "images/Profile_Image.jpg")),format.raw/*7.78*/(""" """),format.raw/*7.79*/("""/></br>

				<span class="userData">"""),_display_(/*9.29*/ActualUser/*9.39*/.getFirstName()),format.raw/*9.54*/("""</span><br /> <span
					class="userData">"""),_display_(/*10.24*/ActualUser/*10.34*/.getEmail()),format.raw/*10.45*/("""</span><br /> <span
					class="linkSidebar"><a
					href="""),_display_(/*12.12*/routes/*12.18*/.Application.changeUserData()),format.raw/*12.47*/(""">Change Passwort</a></span> </br> <span
					class="linkSidebar"><a
					href="""),_display_(/*14.12*/routes/*14.18*/.Application.changeUserData()),format.raw/*14.47*/(""">Change Email</a></span></br>
				<form action="logOut" method="Get">
					<input type="submit" value="Logout" />
				</form>
			</div>
		</div>
	</div>

	<div id="rightSidebar">
		<span class="linkSidebarPic"><a
			href="""),_display_(/*24.10*/routes/*24.16*/.Application.verkaufen()),format.raw/*24.40*/("""><img class="userImage"
				src="""),_display_(/*25.10*/routes/*25.16*/.Assets.at( "images/book_add.png")),format.raw/*25.50*/(""" """),format.raw/*25.51*/("""/></a></span>
	</div>

	"""),_display_(/*28.3*/if(!BookList.isEmpty())/*28.26*/ {_display_(Seq[Any](format.raw/*28.28*/("""

	"""),format.raw/*30.2*/("""<script type="text/javascript">
					$(function() """),format.raw/*31.19*/("""{"""),format.raw/*31.20*/("""
					  """),format.raw/*32.8*/("""$('#userBooks').modal("show")
					"""),format.raw/*33.6*/("""}"""),format.raw/*33.7*/(""");
				</script>



	<div id="respProfil">
		<div class="respUserProfilLink">
			<a href="""),_display_(/*40.13*/routes/*40.19*/.Application.profile()),format.raw/*40.41*/("""><img src="""),_display_(/*40.52*/routes/*40.58*/.Assets.at( "images/Profile_Image.jpg")),format.raw/*40.97*/(""" """),format.raw/*40.98*/("""/></a>
		</div>
		<div class="respUserChangeLink">
			<a href="""),_display_(/*43.13*/routes/*43.19*/.Application.changeUserData()),format.raw/*43.48*/("""><img
				src="""),_display_(/*44.10*/routes/*44.16*/.Assets.at( "images/icon_tools.png")),format.raw/*44.52*/(""" """),format.raw/*44.53*/("""/></a>
		</div>
	</div>


		<h1>Eigene Bücher:</h1>
			<div id="userBooks">
				<div id="boxen">
	"""),_display_(/*52.3*/for(book <- BookList) yield /*52.24*/{_display_(Seq[Any](format.raw/*52.25*/(""" 
	"""),_display_(/*53.3*/if(book.getUser().getId().equals(ActualUser.getId()))/*53.56*/{_display_(Seq[Any](format.raw/*53.57*/("""

			"""),_display_(/*55.5*/if(book.getStatus() == 0)/*55.30*/{_display_(Seq[Any](format.raw/*55.31*/("""
			"""),format.raw/*56.4*/("""<div class="buchbox">
				<img class="buchbild" src="""),_display_(/*57.32*/routes/*57.38*/.Assets.at( "images/bucheinzel.jpg")),format.raw/*57.74*/(""" """),format.raw/*57.75*/("""/>
				<span class="buchtitel"><p>"""),_display_(/*58.33*/book/*58.37*/.getBookName()),format.raw/*58.51*/("""</p> </span> <span
					class="buchtitel"><p>"""),_display_(/*59.28*/book/*59.32*/.getAuther()),format.raw/*59.44*/("""</p></span> <span
					class="buchtitel"><p>"""),_display_(/*60.28*/book/*60.32*/.getISBN()),format.raw/*60.42*/("""</p></span> <a
					href="""),_display_(/*61.12*/routes/*61.18*/.Application.deleteBook(book.getId())),format.raw/*61.55*/("""><img
					class="deleteBook" src="""),_display_(/*62.30*/routes/*62.36*/.Assets.at( "images/Delete_icon.png")),format.raw/*62.73*/("""/></a>
			</div>
			
			""")))}/*65.5*/else/*65.9*/{_display_(Seq[Any](format.raw/*65.10*/("""
			"""),format.raw/*66.4*/("""<div class="buchbox">
				<img class="buchbild" src="""),_display_(/*67.32*/routes/*67.38*/.Assets.at( "images/verkauft.gif")),format.raw/*67.72*/(""" """),format.raw/*67.73*/("""/>
				<span class="buchtitel"><p>"""),_display_(/*68.33*/book/*68.37*/.getBookName()),format.raw/*68.51*/("""</p> </span> <span
					class="buchtitel"><p>"""),_display_(/*69.28*/book/*69.32*/.getAuther()),format.raw/*69.44*/("""</p></span> <span
					class="buchtitel"><p>"""),_display_(/*70.28*/book/*70.32*/.getISBN()),format.raw/*70.42*/("""</p></span> <span
					class="buchtitel"><p>Email an: 
						"""),_display_(/*72.8*/book/*72.12*/.getBuyer().getEmail()),format.raw/*72.34*/(""" """),format.raw/*72.35*/("""</p></span> <a
					href="""),_display_(/*73.12*/routes/*73.18*/.Application.deleteBook(book.getId())),format.raw/*73.55*/("""><img
					class="deleteBook" src="""),_display_(/*74.30*/routes/*74.36*/.Assets.at( "images/Delete_icon.png")),format.raw/*74.73*/("""/></a>
			</div>

			""")))}),format.raw/*77.5*/("""
		
		
	
	""")))}),format.raw/*81.3*/(""" """)))}),format.raw/*81.5*/(""" """)))}),format.raw/*81.7*/(""" 
	"""),_display_(/*82.3*/if(!BookList.isEmpty())/*82.26*/ {_display_(Seq[Any](format.raw/*82.28*/("""

	"""),format.raw/*84.2*/("""<script type="text/javascript">
						$(function() """),format.raw/*85.20*/("""{"""),format.raw/*85.21*/("""
						  """),format.raw/*86.9*/("""$('#userBooks').modal("show")
						"""),format.raw/*87.7*/("""}"""),format.raw/*87.8*/(""");
					</script>
	<div style="clear:both"></div>
	<div class="boughtBooks"><h1>Einkäufe:</h1></div>				
					
	"""),_display_(/*92.3*/for(book <- BookList) yield /*92.24*/{_display_(Seq[Any](format.raw/*92.25*/(""" """),_display_(/*92.27*/if((book.getStatus() ==
	1)&&(book.getBuyer().getId().equals(ActualUser.getId())))/*93.59*/{_display_(Seq[Any](format.raw/*93.60*/("""
			
			
			"""),format.raw/*96.4*/("""<div class="buchbox">
				<img class="buchbild" src="""),_display_(/*97.32*/routes/*97.38*/.Assets.at( "images/bucheinzel.jpg")),format.raw/*97.74*/(""" """),format.raw/*97.75*/("""/>
				<span class="buchtitel"><p>"""),_display_(/*98.33*/book/*98.37*/.getBookName()),format.raw/*98.51*/("""</p> </span> <span
					class="buchtitel"><p>"""),_display_(/*99.28*/book/*99.32*/.getAuther()),format.raw/*99.44*/("""</p></span> <span
					class="buchtitel"><p>"""),_display_(/*100.28*/book/*100.32*/.getISBN()),format.raw/*100.42*/("""</p></span>
			</div>
	""")))}),format.raw/*102.3*/(""" """)))}),format.raw/*102.5*/(""" """)))}),format.raw/*102.7*/("""
		"""),format.raw/*103.3*/("""</div>
	</div>
	<div style="clear:both"></div>
</div>

""")))}),format.raw/*108.2*/("""
"""))}
  }

  def render(BookList:List[Book],ActualUser:User): play.twirl.api.HtmlFormat.Appendable = apply(BookList,ActualUser)

  def f:((List[Book],User) => play.twirl.api.HtmlFormat.Appendable) = (BookList,ActualUser) => apply(BookList,ActualUser)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Jan 15 18:56:03 CET 2015
                  SOURCE: C:/Users/Fabian/Documents/WebTech/buechern/app/views/profile.scala.html
                  HASH: 4dbc4c94b8d533638dd9db57d4bfe2d5f8e14268
                  MATRIX: 734->1|862->41|890->43|913->58|951->59|981->63|1139->195|1153->201|1212->240|1240->241|1305->280|1323->290|1358->305|1429->349|1448->359|1480->370|1568->431|1583->437|1633->466|1741->547|1756->553|1806->582|2065->814|2080->820|2125->844|2186->878|2201->884|2256->918|2285->919|2339->947|2371->970|2411->972|2443->977|2522->1028|2551->1029|2587->1038|2650->1074|2678->1075|2802->1172|2817->1178|2860->1200|2898->1211|2913->1217|2973->1256|3002->1257|3095->1323|3110->1329|3160->1358|3203->1374|3218->1380|3275->1416|3304->1417|3437->1524|3474->1545|3513->1546|3544->1551|3606->1604|3645->1605|3679->1613|3713->1638|3752->1639|3784->1644|3865->1698|3880->1704|3937->1740|3966->1741|4029->1777|4042->1781|4077->1795|4151->1842|4164->1846|4197->1858|4270->1904|4283->1908|4314->1918|4368->1945|4383->1951|4441->1988|4504->2024|4519->2030|4577->2067|4623->2095|4635->2099|4674->2100|4706->2105|4787->2159|4802->2165|4857->2199|4886->2200|4949->2236|4962->2240|4997->2254|5071->2301|5084->2305|5117->2317|5190->2363|5203->2367|5234->2377|5324->2441|5337->2445|5380->2467|5409->2468|5463->2495|5478->2501|5536->2538|5599->2574|5614->2580|5672->2617|5727->2642|5772->2657|5804->2659|5836->2661|5867->2666|5899->2689|5939->2691|5971->2696|6051->2748|6080->2749|6117->2759|6181->2796|6209->2797|6353->2915|6390->2936|6429->2937|6458->2939|6550->3022|6589->3023|6631->3038|6712->3092|6727->3098|6784->3134|6813->3135|6876->3171|6889->3175|6924->3189|6998->3236|7011->3240|7044->3252|7118->3298|7132->3302|7164->3312|7221->3338|7254->3340|7287->3342|7319->3346|7411->3407
                  LINES: 26->1|29->1|29->1|29->1|29->1|31->3|35->7|35->7|35->7|35->7|37->9|37->9|37->9|38->10|38->10|38->10|40->12|40->12|40->12|42->14|42->14|42->14|52->24|52->24|52->24|53->25|53->25|53->25|53->25|56->28|56->28|56->28|58->30|59->31|59->31|60->32|61->33|61->33|68->40|68->40|68->40|68->40|68->40|68->40|68->40|71->43|71->43|71->43|72->44|72->44|72->44|72->44|80->52|80->52|80->52|81->53|81->53|81->53|83->55|83->55|83->55|84->56|85->57|85->57|85->57|85->57|86->58|86->58|86->58|87->59|87->59|87->59|88->60|88->60|88->60|89->61|89->61|89->61|90->62|90->62|90->62|93->65|93->65|93->65|94->66|95->67|95->67|95->67|95->67|96->68|96->68|96->68|97->69|97->69|97->69|98->70|98->70|98->70|100->72|100->72|100->72|100->72|101->73|101->73|101->73|102->74|102->74|102->74|105->77|109->81|109->81|109->81|110->82|110->82|110->82|112->84|113->85|113->85|114->86|115->87|115->87|120->92|120->92|120->92|120->92|121->93|121->93|124->96|125->97|125->97|125->97|125->97|126->98|126->98|126->98|127->99|127->99|127->99|128->100|128->100|128->100|130->102|130->102|130->102|131->103|136->108
                  -- GENERATED --
              */
          