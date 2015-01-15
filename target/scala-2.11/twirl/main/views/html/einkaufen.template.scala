
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
object einkaufen extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.4*/(""" """),_display_(/*1.6*/main("einkaufen")/*1.23*/{_display_(Seq[Any](format.raw/*1.24*/("""

"""),format.raw/*3.1*/("""<div id="content">
	
	<script type="text/javascript">
		$(document).ready(function() """),format.raw/*6.32*/("""{"""),format.raw/*6.33*/("""
			"""),format.raw/*7.4*/("""suche();
		"""),format.raw/*8.3*/("""}"""),format.raw/*8.4*/(""");	
	
		function suche()"""),format.raw/*10.19*/("""{"""),format.raw/*10.20*/("""
			"""),format.raw/*11.4*/("""if((document.getElementById("sucheBook").value.length >=1) ||(document.getElementById("sucheBook").value ==0))"""),format.raw/*11.114*/("""{"""),format.raw/*11.115*/("""
				"""),format.raw/*12.5*/("""var sText = document.getElementById("sucheBook").value;
				var requestObj = new XMLHttpRequest();
				requestObj.onreadystatechange = function()"""),format.raw/*14.47*/("""{"""),format.raw/*14.48*/("""
					"""),format.raw/*15.6*/("""if (requestObj.readyState == 4 && requestObj.status == 200)"""),format.raw/*15.65*/("""{"""),format.raw/*15.66*/("""
						"""),format.raw/*16.7*/("""document.getElementById("buch").innerHTML = requestObj.responseText;
						requestObj = null;
						
					"""),format.raw/*19.6*/("""}"""),format.raw/*19.7*/("""
				"""),format.raw/*20.5*/("""}"""),format.raw/*20.6*/("""
				"""),format.raw/*21.5*/("""requestObj.open("GET","searchBook?sucheBook="+sText, true);
				requestObj.send();
			"""),format.raw/*23.4*/("""}"""),format.raw/*23.5*/("""
		"""),format.raw/*24.3*/("""}"""),format.raw/*24.4*/("""

		
		

	"""),format.raw/*29.2*/("""</script>
	
	<div id="boxen">
		<h1>Buchangebote für Sie:</h1>
		
		<input type="text" placeholder="SUCHE: Titel /ISBN /Autor.."
					name="sucheBook" id="sucheBook" onkeyup="suche()">
	
			<span class="buch" id=buch> </span> 
	</div>
	
</div>

""")))}),format.raw/*42.2*/("""
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Jan 15 18:56:03 CET 2015
                  SOURCE: C:/Users/Fabian/Documents/WebTech/buechern/app/views/einkaufen.scala.html
                  HASH: 26930f36157d60ce87e85f0dea16074a5443c99c
                  MATRIX: 720->1|809->3|836->5|861->22|899->23|929->27|1044->115|1072->116|1103->121|1141->133|1168->134|1222->160|1251->161|1283->166|1422->276|1452->277|1485->283|1660->430|1689->431|1723->438|1810->497|1839->498|1874->506|2010->615|2038->616|2071->622|2099->623|2132->629|2247->717|2275->718|2306->722|2334->723|2376->738|2665->997
                  LINES: 26->1|29->1|29->1|29->1|29->1|31->3|34->6|34->6|35->7|36->8|36->8|38->10|38->10|39->11|39->11|39->11|40->12|42->14|42->14|43->15|43->15|43->15|44->16|47->19|47->19|48->20|48->20|49->21|51->23|51->23|52->24|52->24|57->29|70->42
                  -- GENERATED --
              */
          